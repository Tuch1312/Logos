package com.dettofatto.logos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroLezione;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Lezione;
import com.dettofatto.logos.fragment.LezioniAdapter;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by itsadmin on 20/03/2018.
 */

public class EliminaLezione extends AppCompatActivity {

    List<Lezione> lista;
    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_elimina_lezione);

        final Gson gson = new Gson();
        final String t = "{\"idCorso\":\"1\"}";

        final ListView lv = findViewById(R.id.listaEliminaLezioni);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        final Call<List<Lezione>> c = rv.getLezioniPerCorso(t);

        c.enqueue(new Callback<List<Lezione>>() {
            @Override
            public void onResponse(Call<List<Lezione>> call, Response<List<Lezione>> response) {
                lista = response.body();
                LezioniAdapter la = new LezioniAdapter(getApplicationContext(),lista);
                lv.setAdapter(la);
            }

            @Override
            public void onFailure(Call<List<Lezione>> call, Throwable t) {

            }
        });
        final RetroLezione rl = RetrofitSingleton.r.create(RetroLezione.class);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Call<Boolean> call = rl.eliminalezione(gson.toJson(lv.getItemAtPosition(position)), t);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(getApplicationContext(), "fatto", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
    }



}
