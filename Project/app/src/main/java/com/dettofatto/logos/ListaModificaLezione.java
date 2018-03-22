package com.dettofatto.logos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dettofatto.logos.entities.Lezione;

public class ListaModificaLezione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_modifica_lezione);
        final ListView lv = findViewById(R.id.listaEliminaLezioni);
        final Intent toModificaLez = new Intent(this, ModificaLezione.class);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lezione l = (Lezione) lv.getItemAtPosition(position);
                toModificaLez.putExtra("lezione", l);
                startActivity(toModificaLez);
            }
        });
    }
}
