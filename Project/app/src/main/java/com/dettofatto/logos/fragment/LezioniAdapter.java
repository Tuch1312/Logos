package com.dettofatto.logos.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.entities.Lezione;

import java.util.List;

public class LezioniAdapter extends ArrayAdapter<Lezione> {
    public LezioniAdapter(Context context, List<Lezione> listaLezioni) {
        super(context, 0, listaLezioni);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Lezione lezione = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_lezioni_riga, parent, false);
        }
        // Lookup view for data population
        TextView data = (TextView) convertView.findViewById(R.id.lista_lezioni_riga_data);
        TextView aula = (TextView) convertView.findViewById(R.id.lista_lezioni_riga_aula);
        TextView ora = (TextView) convertView.findViewById(R.id.lista_lezioni_riga_ora);
        TextView numeroLezione =(TextView) convertView.findViewById(R.id.lista_lezioni_riga_numero);
        // Populate the data into the template view using the data object
        data.setText(""+lezione.getData());
        aula.setText(""+lezione.getAula());
        ora.setText(""+lezione.getOraInizio());
        numeroLezione.setText(""+lezione.getNumeroLezione());
        // Return the completed view to render on screen
        return convertView;
    }


}
