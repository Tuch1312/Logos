package com.dettofatto.logos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Lezione;

/**
 * Created by itsadmin on 20/03/2018.
 */

public class ModificaLezione extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_lezione);

        final EditText e1 = findViewById(R.id.editTextModArgomenti);
        final EditText e2 = findViewById(R.id.editTextModAula);
        final EditText e3 = findViewById(R.id.editTextModData);
        final EditText e4 = findViewById(R.id.editTextModDurata);
        final EditText e5 = findViewById(R.id.editTextModOraInizio);

        Intent i = getIntent();
        final Lezione lezione = (Lezione) i.getSerializableExtra("lezione");
        e1.setText(""+lezione.getArgomenti());
        e2.setText(""+lezione.getAula());
        e3.setText(""+lezione.getData());
        e4.setText(""+lezione.getDurata());
        e5.setText(""+lezione.getOraInizio());

        Button b = findViewById(R.id.btnModificaLezione);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lezione.setArgomenti(e1.getText().toString());
                lezione.setAula(e2.getText().toString());
                lezione.setData(Long.parseLong(e3.getText().toString()));
                lezione.setDurata(Integer.parseInt(e4.getText().toString()));
                lezione.setOraInizio(e5.getText().toString());
            }
        });
    }
}
