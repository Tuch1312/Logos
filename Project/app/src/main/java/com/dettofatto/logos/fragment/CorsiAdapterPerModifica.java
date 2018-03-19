package com.dettofatto.logos.fragment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dettofatto.logos.FormModifica;
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

    Context ctx = null;
    public CorsiAdapterPerModifica(Context context, List<Corso> listaCorsi) {
        super(context, 0, listaCorsi);
        ctx = context;
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
        Button b = convertView.findViewById(R.id.bottone_modifica);
        b.setVisibility(View.VISIBLE);
        // Populate the data into the template view using the data object
        titoloCorso.setText(corso.getTitolo());
        dataInizio.setVisibility(View.GONE);
        contatore.setVisibility(View.GONE);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toModifica = new Intent(ctx, FormModifica.class);
                toModifica.putExtra("corso", corso);
                ctx.startActivity(toModifica);
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }


}