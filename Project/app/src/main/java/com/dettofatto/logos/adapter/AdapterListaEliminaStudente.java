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

/**
 * Created by itsadmin on 23/03/2018.
 */

public class AdapterListaEliminaStudente extends ArrayAdapter <Studente>{
   Context ctx;
   ArrayList<Studente> values;

   public AdapterListaEliminaStudente(Context ctx, ArrayList<Studente> values){
       super(ctx, R.layout.row_lista_studente_eliminare, values);

       this.ctx = ctx;
       this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.row_lista_studente_eliminare, parent, false);
        TextView nomeStud = (TextView) rowView.findViewById(R.id.nome_studente);
        TextView cognomeStud = (TextView) rowView.findViewById(R.id.cognome_studente);
        TextView mailStud = (TextView) rowView.findViewById(R.id.mail_studente);

        nomeStud.setText(values.get(position).getNome().toString());
        cognomeStud.setText(values.get(position).getCognome().toString());
        mailStud.setText(values.get(position).getMail().toString());

        return rowView;
    }
}
