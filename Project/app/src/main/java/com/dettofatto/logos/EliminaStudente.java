package com.dettofatto.logos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.adapter.AdapterListaEliminaStudente;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Studente;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class EliminaStudente extends AppCompatActivity {
    AdapterListaEliminaStudente ales;
    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_elimina_studente);

        Intent i = getIntent();
        final Gson gson = new Gson();
        final Corso c = (Corso)i.getSerializableExtra("Corso");
        final Docente d = (Docente)i.getSerializableExtra("Docente");

        final ListView lv = findViewById(R.id.lista_studenti);

        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Studente>> call = rv.getStudentiPerCorso(gson.toJson(c));
        call.enqueue(new Callback<List<Studente>>() {
            @Override
            public void onResponse(Call<List<Studente>> call, Response<List<Studente>> response) {
                List<Studente> lista = response.body();
                ales = new AdapterListaEliminaStudente(getApplication(), lista);
                lv.setAdapter(ales);
            }

            @Override
            public void onFailure(Call<List<Studente>> call, Throwable t) {

            }
        });
        final RetroCorso rc = RetrofitSingleton.r.create(RetroCorso.class);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Call<Boolean> call2 = rc.cancellaStudente(gson.toJson(ales.getItem(position)), gson.toJson(c), gson.toJson(d));
                call2.enqueue(new Callback<Boolean>() {
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
