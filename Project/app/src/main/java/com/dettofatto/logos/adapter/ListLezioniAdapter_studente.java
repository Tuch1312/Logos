package com.dettofatto.logos.adapter;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dettofatto.logos.CreaCorso;
import com.dettofatto.logos.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tuch on 09/02/18.
 */

public class ListLezioniAdapter_studente extends ArrayAdapter<CreaCorso> {


    Context ctx;
    ArrayList<CreaCorso> lista;

    public ListLezioniAdapter_studente(Context ctx, ArrayList<CreaCorso> values) {
        super(ctx, R.layout.lista_lezioni_riga, values);

        this.ctx = ctx;
        this.lista = values;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View V = inflater.inflate(R.layout.lista_lezioni_riga, parent, false);
        TextView data = V.findViewById(R.id.lista_lezioni_riga_data);
        TextView ora = V.findViewById(R.id.lista_lezioni_riga_ora);
        TextView aula = V.findViewById(R.id.lista_lezioni_riga_aula);
        TextView numero = V.findViewById(R.id.lista_lezioni_riga_numero);
        return V;

    }
}
