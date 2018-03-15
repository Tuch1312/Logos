package com.dettofatto.logos.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.entities.Corso;

import java.util.List;

public class CorsiAdapter extends ArrayAdapter<Corso> {
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
        Button b = convertView.findViewById(R.id.bottone_elimina);

        // Populate the data into the template view using the data object
        titoloCorso.setText(corso.getTitolo());
        dataInizio.setText(""+corso.getDataInizio());
        contatore.setText(""+corso.getContatoreGiorniInterno());
        // Return the completed view to render on screen
        return convertView;
    }


 }
