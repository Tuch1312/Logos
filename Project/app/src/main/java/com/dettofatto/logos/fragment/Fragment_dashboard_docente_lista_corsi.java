package com.dettofatto.logos.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.DashboardDocenteCorsi;
import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


class CorsiAdapter extends ArrayAdapter<Corso>{
    public CorsiAdapter(Context context, List<Corso> listaCorsi) {
        super(context, 0, listaCorsi);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Corso corso = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_corsi_riga, parent, false);
        }
        // Lookup view for data population
        TextView titoloCorso = (TextView) convertView.findViewById(R.id.titoloCorso);
        TextView dataInizio = (TextView) convertView.findViewById(R.id.dataInizio);
        TextView contatore = (TextView) convertView.findViewById(R.id.contatore);
        // Populate the data into the template view using the data object
        titoloCorso.setText(corso.getTitolo());
        dataInizio.setText(""+corso.getDataInizio());
        contatore.setText(""+corso.getContatoreGiorniInterno());
        // Return the completed view to render on screen
        return convertView;
    }


 }















public class Fragment_dashboard_docente_lista_corsi extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_lista_corsi, container, false);

        return V;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Docente Json = new Docente();
        Json.setMail("ciaone");
        String g = "{\"mail\":\"docente@mail\"}";

        final Intent toDashCorso = new Intent(getContext(), DashboardDocenteCorsi.class);
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final ListView lv = view.findViewById(R.id.listacorsi);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Corso>> c = rv.getCorsiPerDocente(g);
        c.enqueue(new Callback<List<Corso>>() {
            @Override
            public void onResponse(Call<List<Corso>> call, Response<List<Corso>> response) {
                List<Corso> lista = response.body();
                CorsiAdapter corsiAdapter = new CorsiAdapter(getContext(), lista);
                lv.setAdapter(corsiAdapter);
            }

            @Override
            public void onFailure(Call<List<Corso>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(toDashCorso);
            }
        });



    }

}
