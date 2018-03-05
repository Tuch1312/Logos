package com.dettofatto.logos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.CreaCorso;
import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.adapter.ListLezioniAdapter_studente;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Lezione;
import com.dettofatto.logos.entities.Studente;
import com.google.gson.Gson;
import com.jackandphantom.circularprogressbar.CircleProgressbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Tuch on 08/02/18.
 */

public class Fragment_dashboard_studente_lezioni extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_studente_lezioni, container, false);
        return V;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        Bundle b = getArguments();
        Corso corso = (Corso) b.getSerializable("corso");
        Gson j = new Gson();
        String g = j.toJson(corso);

        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        final ListView lv = view.findViewById(R.id.dashboard_studente_lezioni_1);
        retrofit2.Call<List<Lezione>> call = rv.getLezioniPerCorso(g);
        call.enqueue(new Callback<List<Lezione>>(){
            @Override
            public void onResponse(retrofit2.Call<List<Lezione>> call, Response<List<Lezione>> response) {
                List<Lezione> lista = response.body();
                LezioniAdapter lezioniAdapter = new LezioniAdapter(getContext(), lista);
                lv.setAdapter(lezioniAdapter);


            }

            @Override
            public void onFailure(retrofit2.Call<List<Lezione>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }

    private String formatDate(Long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM");
        return sdf.format(new Date(date));

    }
}