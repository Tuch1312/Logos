package com.dettofatto.logos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.dettofatto.logos.entities.Presenza;
import com.dettofatto.logos.R;
import com.dettofatto.logos.presenzarow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by itsadmin on 22/01/2018.
 */

public class AdapterListaPresenze extends ArrayAdapter<Presenza> {

    Context ctx;  // superclasse da cui si estedono sottoclassi, tra ci c'è la mia activity
    ArrayList<Presenza> values;


            public AdapterListaPresenze(Context ctx, ArrayList<Presenza> values) {
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


                nomeView.setText(values.get(position).getStudente().getNome().toString());
                cognomeView.setText(values.get(position).getStudente().getCognome().toString());
                ingressoView.setText(formatTime(values.get(position).getOraArrivo()));
                uscitaView.setText(formatTime(values.get(position).getOraUscita()));
                swi.setChecked(values.get(position).isPresass());

                return rowView;

            }

            private String formatTime(Long dateObject) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                return timeFormat.format(new Date(dateObject));
            }
        }


