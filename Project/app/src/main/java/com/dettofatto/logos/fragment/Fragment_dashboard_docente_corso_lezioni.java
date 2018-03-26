package com.dettofatto.logos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dettofatto.logos.DashboardDocenteLezione;
import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Lezione;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Tuch on 08/02/18.
 */

public class Fragment_dashboard_docente_corso_lezioni extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_corso_lezioni, container, false);

        return V;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle b = getArguments();
        final Docente d = (Docente) b.getSerializable("Docente");
        final Corso corso = (Corso) b.getSerializable("Corso");
        Gson gson = new Gson();
        String g = gson.toJson(corso);


        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final ListView lv = view.findViewById(R.id.dash_docente_corso_lezioni);

        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Lezione>> c = rv.getLezioniPerCorso(g);


        c.enqueue(new Callback<List<Lezione>>() {
            @Override
            public void onResponse(Call<List<Lezione>> call, Response<List<Lezione>> response) {
                List<Lezione> lista = response.body();
                LezioniAdapter lezioniAdapter = new LezioniAdapter(getContext(), lista);
                lv.setAdapter(lezioniAdapter);
            }

            @Override
            public void onFailure(Call<List<Lezione>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
