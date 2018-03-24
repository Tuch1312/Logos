package com.dettofatto.logos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Lezione;

public class DashboardDocenteLezione extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_docente_lezione);

        Intent i = getIntent();
        Docente d = (Docente) i.getSerializableExtra("Docente");
        Lezione l = (Lezione) i.getSerializableExtra("Lezione");


        TextView argomenti = findViewById(R.id.argomenti_text);
        argomenti.setText(""+ l.getArgomenti());
        TextView numeroLezione = findViewById(R.id.numero_lezione_text);
        numeroLezione.setText(""+ l.getNumeroLezione());
        TextView aula = findViewById(R.id.aula_text);
        aula.setText(""+ l.getAula());
        TextView data = findViewById(R.id.data_text);
        data.setText(""+ l.getData());
        TextView oraInizio = findViewById(R.id.ora_inizio_text);
        oraInizio.setText(""+ l.getOraInizio());
        TextView durata = findViewById(R.id.durata_text);
        durata.setText(""+ l.getDurata());
        TextView numAssenti = findViewById(R.id.num_assenti_text);
        numAssenti.setText(""+ l.getNumAssenti());
        TextView percentAssenti = findViewById(R.id.percent_assenti_text);
        percentAssenti.setText(""+ l.getPercentAssenti());


    }
}
