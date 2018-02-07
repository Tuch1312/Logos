package com.dettofatto.logos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by itsadmin on 22/01/2018.
 */

public class AdapterListaPresenze extends ArrayAdapter<Presenzarow> {

    Context ctx;  // superclasse da cui si estedono sottoclassi, tra ci c'è la mia activity
    ArrayList<Presenzarow> values;

    public AdapterListaPresenze(Context ctx, ArrayList<Presenzarow> values) {
        super(ctx, R.layout.rows_list_presenze, values);

        this.ctx = ctx;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rows_list_presenze, parent, false);
        TextView nomeView = (TextView) rowView.findViewById(R.id.nomeStudPres);
        TextView cognomeView = (TextView) rowView.findViewById(R.id.cognomeStudPres);
        TextView ingressoView = (TextView) rowView.findViewById(R.id.ingressoPres);
        TextView uscitaView = (TextView) rowView.findViewById(R.id.uscitaPres);
        Switch swi = (Switch) rowView.findViewById(R.id.studentePresAss);


        nomeView.setText(values.get(position).nome);
        cognomeView.setText("" + values.get(position).cognome);
        ingressoView.setText("" + values.get(position).ingresso);
        uscitaView.setText("" +values.get(position).uscita);
        swi.setChecked(values.get(position).presass);
        return rowView;

    }
}

