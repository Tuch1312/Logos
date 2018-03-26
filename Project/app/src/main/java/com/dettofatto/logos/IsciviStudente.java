package com.dettofatto.logos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.EditText;

import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.entities.Corso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
     * Created by itsadmin on 23/03/2018.
     */

    public class IsciviStudente extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedIstanceState) {
            super.onCreate(savedIstanceState);
            setContentView(R.layout.activity_iscrivi_studente);

            final EditText editText = findViewById(R.id.mail_studente_iscrivere);

            RetroCorso retroCorso = RetrofitSingleton.r.create(RetroCorso.class);
            Call<Boolean> b = retroCorso.iscriviStudente();
            b.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {

                }
            });
        }

    }

