package com.dettofatto.logos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.CreaCorso;
import com.dettofatto.logos.R;
import com.dettofatto.logos.adapter.ListLezioniAdapter_studente;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tuch on 08/02/18.
 */

public class Fragment_dashboard_studente_lezioni extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_studente_lezioni, container, false);

        //Oggetti dell'intefaccia garfica
        TextView titoloCorso = V.findViewById(R.id.dashboard_studente_lezioni_titoloCorso);
        TextView data = V.findViewById(R.id.dashboard_studente_lezioni_data);
        ListView listaLezioni = V.findViewById(R.id.dashboard_studente_lezioni_listaLezioni);

        //Visualizzo la data corrente di sistema
        data.setText(formatDate(Calendar.getInstance().getTime().getTime()));

        //Solo a scopo di test
        ArrayList lista = new ArrayList();
        String a = "a";
        String b = "b";
        lista.add(a);
        lista.add(b);

        //Istanzio un adapter per la lista di lezioni
        ListLezioniAdapter_studente adapter = new ListLezioniAdapter_studente(getContext(),lista);
        listaLezioni.setAdapter(adapter);

        return V;
    }

    private String formatDate(Long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
        return sdf.format(new Date(date));

    }
}