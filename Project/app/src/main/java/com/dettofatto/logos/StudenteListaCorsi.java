package com.dettofatto.logos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Studente;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;






class CorsiStudenteAdapter extends ArrayAdapter<Corso> {
    public CorsiStudenteAdapter(Context context, List<Corso> listaCorsi) {
        super(context, 0, listaCorsi);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Corso corso = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lista_corsi_riga, parent, false);
        }
        // Lookup view for data population
        TextView titoloCorso = (TextView) convertView.findViewById(R.id.titoloCorso);
        TextView dataInizio = (TextView) convertView.findViewById(R.id.dataInizio);
        TextView contatore = (TextView) convertView.findViewById(R.id.contatore);
        // Populate the data into the template view using the data object
        titoloCorso.setText(corso.getTitolo());
        dataInizio.setText(""+corso.getDataInizio());
        contatore.setText(""+corso.getContatoreGiorniInterno());
        // Return the completed view to render on screen
        return convertView;
    }


}

public class StudenteListaCorsi extends AppCompatActivity {

    List<Corso> lista;
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studente_lista_corsi);

        dl = findViewById(R.id.drawer_studente_lista_corsi);

        //this allow to create and set a toolbar because the theme setted as default doesn't have an action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_Studente_lista_corsi);
        setSupportActionBar(myToolbar);

        //this let us use the menu icon on the top left of the activity
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        //listener of the item inside the drawer layout
        NavigationView navigationView = findViewById(R.id.nav_view_studente_lista_corsi);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        dl.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });




        Intent i = getIntent();
        final Studente s = (Studente) i.getSerializableExtra("studente");
        Gson j = new Gson();
        String g = j.toJson(s);

        final Intent toDashStudente = new Intent(this, DashBoardStudente.class);


        final ListView lv = findViewById(R.id.lcStudente);
        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        Call<List<Corso>> c = rv.getCorsiPerStudente(g);
        c.enqueue(new Callback<List<Corso>>() {
            @Override
            public void onResponse(Call<List<Corso>> call, Response<List<Corso>> response) {
                lista = response.body();
                CorsiStudenteAdapter corsistudenteAdapter = new CorsiStudenteAdapter(getApplicationContext(), lista);
                lv.setAdapter(corsistudenteAdapter);
            }

            @Override
            public void onFailure(Call<List<Corso>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toDashStudente.putExtra("studente", s);
                toDashStudente.putExtra("corso",lista.get(position));
                startActivity(toDashStudente);
            }
        });
    }


    //Listener of the menu icon that open the drawer menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
