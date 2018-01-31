package com.dettofatto.logos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * Created by itsadmin on 22/01/2018.
 */

public class Adapter extends ArrayAdapter<presenzarow> {

    Context ctx;  // superclasse da cui si estedono sottoclassi, tra ci c'è la mia activity
    ArrayList<presenzarow> values;

    public Adapter(Context ctx, ArrayList<presenzarow> values) {
        super(ctx, R.layout.rows_list_presenze, values);

        this.ctx = ctx;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rows_list_presenze, parent, false);
        TextView nomeView = (TextView) rowView.findViewById(R.id.nome);
        TextView cognomeView = (TextView) rowView.findViewById(R.id.cognome);
        TextView ingressoView = (TextView) rowView.findViewById(R.id.oraingresso);
        TextView uscitaView = (TextView) rowView.findViewById(R.id.orauscita);
        Switch swi = (Switch) rowView.findViewById(R.id.switchbtn);


        nomeView.setText(values.get(position).nome);
        cognomeView.setText("" + values.get(position).cognome);
        ingressoView.setText("" + values.get(position).ingresso);
        uscitaView.setText("" +values.get(position).uscita);
        swi.setChecked(values.get(position).presass);
        return rowView;

    }
}

