package com.dettofatto.logos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Studente;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IscrizioneCorsoStudente extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iscrizione_corso_studente);
        final Studente s = new Studente();
        s.setMail("yolo");
        final Corso c = new Corso();
        c.setIdCorso(1);
        final Gson gson = new Gson();

        EditText inserisciCodice = findViewById(R.id.editText6);
        Button iscriviti = findViewById(R.id.button2);
        final RetroCorso rc = RetrofitSingleton.r.create(RetroCorso.class);

        iscriviti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Boolean> call = rc.iscriviti(gson.toJson(s), c.getIdCorso());
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
