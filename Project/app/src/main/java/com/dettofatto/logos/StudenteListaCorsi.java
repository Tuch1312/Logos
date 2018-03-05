package com.dettofatto.logos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;






class CorsiStudenteAdapter extends ArrayAdapter<Corso> {
    public CorsiStudenteAdapter(Context context, List<Corso> listaCorsi) {
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

public class StudenteListaCorsi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studente_lista_corsi);

        String g = "{\"mail\":\"a\"}";

        final Intent toDashStudente = new Intent(this, DashBoardStudente.class);
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final ListView lv = findViewById(R.id.lcStudente);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Corso>> c = rv.getCorsiPerStudente(g);
        c.enqueue(new Callback<List<Corso>>() {
            @Override
            public void onResponse(Call<List<Corso>> call, Response<List<Corso>> response) {
                List<Corso> lista = response.body();
                CorsiStudenteAdapter corsistudenteAdapter = new CorsiStudenteAdapter(getApplicationContext(), lista);
                lv.setAdapter(corsistudenteAdapter);
            }

            @Override
            public void onFailure(Call<List<Corso>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(toDashStudente);
            }
        });
    }
}
