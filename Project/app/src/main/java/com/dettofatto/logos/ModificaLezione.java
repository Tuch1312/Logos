package com.dettofatto.logos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroLezione;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Lezione;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by itsadmin on 20/03/2018.
 */

public class ModificaLezione extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_lezione);

        Intent i = getIntent();
        final Lezione l = (Lezione) i.getSerializableExtra("lezione");
        final Corso corso = (Corso) i.getSerializableExtra("Corso");
        final EditText e1 = findViewById(R.id.editTextModArgomenti);
        final EditText e2 = findViewById(R.id.editTextModAula);
        final EditText e3 = findViewById(R.id.editTextModData);
        final EditText e4 = findViewById(R.id.editTextModDurata);
        final EditText e5 = findViewById(R.id.editTextModOraInizio);
        e1.setText(l.getArgomenti());
        e2.setText(l.getAula());
        e3.setText(""+l.getData());
        e4.setText(""+l.getDurata());
        e5.setText(""+l.getOraInizio());

        final Gson gson = new Gson();
        final String t = gson.toJson(corso);

        final RetroLezione rl = RetrofitSingleton.r.create(RetroLezione.class);

        Button b = findViewById(R.id.btnModificaLezione);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                l.setArgomenti(e1.getText().toString());
                l.setAula(e2.getText().toString());
                l.setData(Long.parseLong(e3.getText().toString()));
                l.setDurata(Integer.parseInt(e4.getText().toString()));
                l.setOraInizio(e5.getText().toString());
                Call<Boolean> call = rl.modificalezione(gson.toJson(l), t);
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
