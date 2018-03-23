package com.dettofatto.logos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Lezione;
import com.dettofatto.logos.fragment.LezioniAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaModificaLezione extends AppCompatActivity {
    List<Lezione> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_modifica_lezione);
        final ListView lv = findViewById(R.id.listaModificaLezioni);
        final String t = "{\"idCorso\":\"1\"}";

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
        final Intent toModificaLez = new Intent(this, ModificaLezione.class);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lezione l = (Lezione) lv.getItemAtPosition(position);
                toModificaLez.putExtra("lezione", l);
                startActivity(toModificaLez);
            }
        });
    }
}
