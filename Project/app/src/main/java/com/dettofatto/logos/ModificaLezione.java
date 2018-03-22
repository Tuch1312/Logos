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
    }
}
