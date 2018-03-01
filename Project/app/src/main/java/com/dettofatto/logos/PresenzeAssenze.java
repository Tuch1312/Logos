package com.dettofatto.logos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dettofatto.logos.adapter.AdapterListaPresenze;
import com.dettofatto.logos.entities.Persona;
import com.dettofatto.logos.entities.Presenza;
import com.dettofatto.logos.entities.Studente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PresenzeAssenze extends Activity {

    ListView listaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenze_assenze);

        listaListView  = findViewById(R.id.listaPresAss);

        //Solo per test
        ArrayList<Presenza> values = new ArrayList<Presenza>();
        Studente s1 = new Studente();
        s1.setNome("matteo");
        s1.setCognome("abc");
        Studente s2 = new Studente();
        s2.setNome("luca");
        s2.setCognome("gfgf");
        Presenza p1 = new Presenza();
        Presenza p2 = new Presenza();
        p1.setStudente(s1);
        p1.setOraArrivo(new Date().getTime());
        p1.setOraUscita(new Date().getTime());
        p2.setStudente(s2);
        p2.setOraArrivo(new Date().getTime());
        p2.setOraUscita(new Date().getTime());

        values.add(p1);
        values.add(p2);

        AdapterListaPresenze adapter = new AdapterListaPresenze(this, values);
        listaListView.setAdapter(adapter);

        listaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listaListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                return false;
            }
        });

    }
}
