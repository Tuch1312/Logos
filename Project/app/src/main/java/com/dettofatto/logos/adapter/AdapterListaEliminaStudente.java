package com.dettofatto.logos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.entities.Studente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class AdapterListaEliminaStudente extends ArrayAdapter <Studente>{
   Context ctx;
   List<Studente> values;

   public AdapterListaEliminaStudente(Context ctx, List<Studente> values){
       super(ctx, R.layout.row_lista_studente_eliminare, values);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
       Studente s = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_lista_studente_eliminare, parent, false);
        }


        TextView nomeStud = (TextView) convertView.findViewById(R.id.nome_studente);
        TextView cognomeStud = (TextView) convertView.findViewById(R.id.cognome_studente);
        TextView mailStud = (TextView) convertView.findViewById(R.id.mail_studente);

        nomeStud.setText(s.getNome());
        cognomeStud.setText(s.getCognome());
        mailStud.setText(s.getMail());

        return convertView;
    }
}
