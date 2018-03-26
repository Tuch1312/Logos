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

public class CreaLezione extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_lezione);

        Intent i = getIntent();
        final Gson gson = new Gson();
        final Corso corso = (Corso) i.getSerializableExtra("Corso");
        Button b = findViewById(R.id.btnCreaLezione);

        final EditText editArgomenti = findViewById(R.id.editTextArgomenti);
        final EditText editAula = findViewById(R.id.editTextAula);
        final EditText editData = findViewById(R.id.editTextData);
        final EditText editDurata = findViewById(R.id.editTextDurata);
        final EditText editOraInizio = findViewById(R.id.editTextOraInizio);

        final Lezione lezione = new  Lezione();

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lezione.setArgomenti(editArgomenti.getText().toString());
                lezione.setAula(editAula.getText().toString());
                lezione.setData(Long.parseLong(editData.getText().toString()));
                lezione.setDurata(Integer.parseInt(editDurata.getText().toString()));
                lezione.setOraInizio(editOraInizio.getText().toString());
                RetroLezione rl = RetrofitSingleton.r.create(RetroLezione.class);
                Call<Boolean> c = rl.aggiungilezione(gson.toJson(lezione), gson.toJson(corso));
                c.enqueue(new Callback<Boolean>() {
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
