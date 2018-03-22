package com.dettofatto.logos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroCorso;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.fragment.CorsiAdapterPerEliminazione;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class FormModifica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_modifica);

        final String g = "{\"mail\":\"docente@mail\"}";
        final Gson gson = new Gson();

        final EditText e1 = findViewById(R.id.editTextTitolo);
        final EditText e2 = findViewById(R.id.editTextDescrizione);
        final EditText e3 = findViewById(R.id.editTextNumStud);
        final EditText e4 = findViewById(R.id.editTextNumGiorni);
        final EditText e5 = findViewById(R.id.editTextDurataLez);
        final EditText e6 = findViewById(R.id.editTextSede);

        Intent i = getIntent();
        final Corso corso = (Corso) i.getSerializableExtra("corso");
        e1.setText(""+corso.getTitolo());
        e2.setText(""+corso.getDescrizione());
        e3.setText(""+corso.getNumMaxStudenti());
        e4.setText(""+corso.getNumeroGiorni());
        e5.setText(""+corso.getDurataLezione());
        e6.setText(""+corso.getSede());

        Button b = findViewById(R.id.BtnModifica);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corso.setTitolo(e1.getText().toString());
                corso.setDescrizione(e2.getText().toString());
                corso.setSede(e6.getText().toString());
                corso.setNumMaxStudenti(Integer.parseInt(e3.getText().toString()));
                corso.setNumeroGiorni(Integer.parseInt(e4.getText().toString()));
                corso.setDurataLezione(Integer.parseInt(e5.getText().toString()));


                RetroCorso rc = RetrofitSingleton.r.create(RetroCorso.class);
                Call<Boolean> c = rc.modificaCorso(g, gson.toJson(corso));
                c.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(getApplicationContext(), "fatto", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Log.e(TAG, t.toString());
                    }
                });
            }
        });


    }
}
