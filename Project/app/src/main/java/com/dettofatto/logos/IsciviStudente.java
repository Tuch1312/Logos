package com.dettofatto.logos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.google.gson.Gson;

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

        final Gson gson = new Gson();
        final Docente d = new Docente();
        d.setMail("docente@mail");
        final Corso c = new Corso();
        c.setIdCorso(1);

        final EditText editText = findViewById(R.id.mail_studente_iscrivere);
        Button iscriviStudente = findViewById(R.id.btn_iscivi_studente);
        final RetroCorso retroCorso = RetrofitSingleton.r.create(RetroCorso.class);

        iscriviStudente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Boolean> b = retroCorso.iscriviStudente(gson.toJson(c), gson.toJson(d), editText.getText().toString());
                b.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(getApplicationContext(), "fatto", Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });

    }

}

