package com.dettofatto.logos.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.DashboardDocenteLezione;
import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Lezione;
import com.google.gson.Gson;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class Fragment_dashboard_docente_lista_lezioni extends Fragment {


    List<Lezione> lista;
    List<Lezione> lista2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_lista_lezioni, container, false);

        return V;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle b = getArguments();
        final Docente d = (Docente) b.getSerializable("docente");
        Gson gson = new Gson();
        String g = gson.toJson(d);

        final Intent toDashLezione = new Intent(getContext(), DashboardDocenteLezione.class);


        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final ListView lv = view.findViewById(R.id.listaLezioni);
        final ListView lv2 = view.findViewById(R.id.listaLezioniDiDomani);

        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Lezione>> c = rv.getLezioniDiOggi(g);
        Call<List<Lezione>> c2 = rv.getLezioniDiDomani(g);


        c.enqueue(new Callback<List<Lezione>>() {
            @Override
            public void onResponse(Call<List<Lezione>> call, Response<List<Lezione>> response) {
                lista = response.body();
                LezioniAdapter lezioniAdapter = new LezioniAdapter(getContext(), lista);
                lv.setAdapter(lezioniAdapter);
            }

            @Override
            public void onFailure(Call<List<Lezione>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        c2.enqueue(new Callback<List<Lezione>>() {
            @Override
            public void onResponse(Call<List<Lezione>> call, Response<List<Lezione>> response) {
                lista2 = response.body();
                LezioniAdapter lezioniAdapter2 = new LezioniAdapter(getContext(), lista2);
                lv2.setAdapter(lezioniAdapter2);
            }

            @Override
            public void onFailure(Call<List<Lezione>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lezione l = lista.get(position);
                toDashLezione.putExtra("Docente", d);
                toDashLezione.putExtra("Lezione", l);
                startActivity(toDashLezione);
            }
        });

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lezione l = lista2.get(position);
                toDashLezione.putExtra("Docente", d);
                toDashLezione.putExtra("Lezione", l);
                startActivity(toDashLezione);
            }
        });


    }
}
