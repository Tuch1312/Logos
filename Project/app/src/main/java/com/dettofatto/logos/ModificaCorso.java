package com.dettofatto.logos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.fragment.CorsiAdapterPerEliminazione;
import com.dettofatto.logos.fragment.CorsiAdapterPerModifica;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ModificaCorso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_corso);

        Intent i = getIntent();
        final Docente d = (Docente) i.getSerializableExtra("Docente");
        final Gson gson = new Gson();
        final String g = gson.toJson(d);

        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        final ListView lv = findViewById(R.id.lista_elimina_corsi);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Corso>> c = rv.getCorsiPerDocente(g);
        c.enqueue(new Callback<List<Corso>>() {
            @Override
            public void onResponse(Call<List<Corso>> call, Response<List<Corso>> response) {
                List<Corso> lista = response.body();
                CorsiAdapterPerModifica corsiAdapter = new CorsiAdapterPerModifica(getApplicationContext(), lista);
                lv.setAdapter(corsiAdapter);
            }

            @Override
            public void onFailure(Call<List<Corso>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
