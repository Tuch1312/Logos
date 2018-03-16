package com.dettofatto.logos;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.fragment.CorsiAdapter;
import com.dettofatto.logos.fragment.CorsiAdapterPerEliminazione;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class EliminaCorso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina_corso);

        Docente Json = new Docente();
        String g = "{\"mail\":\"docente@mail\"}";

        final Intent toDashCorso = new Intent(this, DashboardDocenteCorsi.class);
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final ListView lv = findViewById(R.id.lista_elimina_corsi);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Corso>> c = rv.getCorsiPerDocente(g);
        c.enqueue(new Callback<List<Corso>>() {
            @Override
            public void onResponse(Call<List<Corso>> call, Response<List<Corso>> response) {
                List<Corso> lista = response.body();
                CorsiAdapterPerEliminazione corsiAdapter = new CorsiAdapterPerEliminazione(getApplicationContext(), lista);
                lv.setAdapter(corsiAdapter);
            }

            @Override
            public void onFailure(Call<List<Corso>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });



    }




}

