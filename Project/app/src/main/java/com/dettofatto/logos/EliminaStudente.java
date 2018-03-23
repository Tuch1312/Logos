package com.dettofatto.logos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Studente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class EliminaStudente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_elimina_studente);

        final ListView lv = findViewById(R.id.lista_studenti);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Studente>> c = rv.getStudentiPerCorso();
        c.enqueue(new Callback<List<Studente>>() {
            @Override
            public void onResponse(Call<List<Studente>> call, Response<List<Studente>> response) {

            }

            @Override
            public void onFailure(Call<List<Studente>> call, Throwable t) {

            }
        });
    }
}
