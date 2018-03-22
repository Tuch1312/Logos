package com.dettofatto.logos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Lezione;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by itsadmin on 20/03/2018.
 */

public class EliminaLezione extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_elimina_lezione);

        Corso Json = new Corso();
        String t = "{\"idCorso\":\"1\"}";

        final ListView lv = findViewById(R.id.listaEliminaLezioni);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Lezione>> c = rv.getLezioniPerCorso(t);
        c.enqueue(new Callback<List<Lezione>>() {
            @Override
            public void onResponse(Call<List<Lezione>> call, Response<List<Lezione>> response) {

            }

            @Override
            public void onFailure(Call<List<Lezione>> call, Throwable t) {

            }
        });
    }



}
