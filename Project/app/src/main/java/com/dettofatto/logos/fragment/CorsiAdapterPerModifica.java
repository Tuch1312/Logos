package com.dettofatto.logos.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Corso;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CorsiAdapterPerModifica extends ArrayAdapter<Corso> {
    public CorsiAdapterPerEliminazione(Context context, List<Corso> listaCorsi) {
        super(context, 0, listaCorsi);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Corso corso = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_corsi_riga, parent, false);
        }
        // Lookup view for data population
        TextView titoloCorso = (TextView) convertView.findViewById(R.id.titoloCorso);
        TextView dataInizio = (TextView) convertView.findViewById(R.id.dataInizio);
        TextView contatore = (TextView) convertView.findViewById(R.id.contatore);
        Button b = convertView.findViewById(R.id.bottone_elimina);
        b.setVisibility(View.VISIBLE);
        // Populate the data into the template view using the data object
        titoloCorso.setText(corso.getTitolo());
        dataInizio.setVisibility(View.GONE);
        contatore.setVisibility(View.GONE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String g = "{\"mail\":\"docente@mail\"}";
                final Gson gson = new Gson();
                RetroCorso rc = RetrofitSingleton.r.create(RetroCorso.class);
                Call<Boolean> c = rc.eliminaCorso(g, gson.toJson(corso));
                c.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(getContext(), "Fatto", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.e(TAG, t.toString());
                    }
                });
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }


}