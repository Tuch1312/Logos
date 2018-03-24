package com.dettofatto.logos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreaCorso extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_corso);

        Button b = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        Intent i = getIntent();
        final Docente d = (Docente) i.getSerializableExtra("Docente");
        final Gson gson = new Gson();
        final String g = gson.toJson(d);

        final LinearLayout ll = findViewById(R.id.layoutscomparsa);
        final EditText editTitolo = findViewById(R.id.editTitolo);;
        final EditText editDescrizione = findViewById(R.id.editDescrizione);
        final EditText editNumMaxStudenti = findViewById(R.id.editNumMaxStudenti);
        final EditText editSede = findViewById(R.id.editSede);
        final EditText editNumeroGiorni = findViewById(R.id.editNumeroGiorni);
        final EditText editDurataLezione = findViewById(R.id.editDurataLezione);
        //da implementare
        final EditText editNumeroLezioniPerGiorno = findViewById(R.id.editNumeroLezioniPerGiorno);

        final EditText editOraInizioLezioni = findViewById(R.id.editOraInizioLezioni);
        final EditText editPatternLezioni = findViewById(R.id.editPatternLezioni);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll.getVisibility()==View.GONE)
                    ll.setVisibility(View.VISIBLE);
                else
                    ll.setVisibility(View.GONE);
            }
        });

        final Corso corso = new Corso();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corso.setTitolo(editTitolo.getText().toString());
                corso.setDescrizione(editDescrizione.getText().toString());
                corso.setNumMaxStudenti(Integer.parseInt(editNumMaxStudenti.getText().toString()));
                corso.setSede(editSede.getText().toString());
                corso.setImmagine("ciao");
                /*
                corso.setNumeroGiorni(Integer.parseInt(editNumeroGiorni.getText().toString()));
                corso.setDurataLezione(Integer.parseInt(editDurataLezione.getText().toString()));
                corso.setOraInizioLezioni(Integer.parseInt(editOraInizioLezioni.getText().toString()));
                corso.setPatternLezioni(editPatternLezioni.getText().toString());
                */
                String automaticFill = "false";


                RetroCorso rc = RetrofitSingleton.r.create(RetroCorso.class);
                Call<Boolean> c = rc.nuovoCorso( g, gson.toJson(corso), automaticFill );
                c.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(getApplicationContext(), "corso creato", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "corso non creato", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });



            }
}
