package com.dettofatto.logos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroPersona;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Persona;
import com.dettofatto.logos.entities.Studente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity {



    DrawerLayout dl;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         dl = findViewById(R.id.drawer_login);

        //this allow to create and set a toolbar because the theme setted as default doesn't have an action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //this let us use the menu icon on the top left of the activity
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        //listener of the item inside the drawer layout
        NavigationView navigationView = findViewById(R.id.nav_view);
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






        //intent to activities
        final Intent StudentListaCorsi= new Intent(this, StudenteListaCorsi.class );
        final Intent dashboardDocente = new Intent(this, DashBoardDocenteListe.class);
        final Intent registrazione = new Intent(this, Registration.class);

        final EditText editmail = findViewById(R.id.editText);
        final EditText editpassword = findViewById(R.id.editText2);
        Button button = findViewById(R.id.Button);
        Button reg = findViewById(R.id.reg);
        //when the login button is pressed starts a retrofit request
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitSingleton.getInstance();
                RetroPersona rp = RetrofitSingleton.r.create(RetroPersona.class);
                Call<ResponseBody> p =  rp.login(editmail.getText().toString(),editpassword.getText().toString());
                p.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        String o = null;
                        try {
                            o = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //analyzing the body string for understand which object is returned
                        //Docente
                        if(o.contains("oreDaTenere")){
                            Gson j = new Gson();
                            Docente d = j.fromJson(o, Docente.class);
                            dashboardDocente.putExtra("docente", d);
                            startActivity(dashboardDocente);
                        }
                        //Studente
                        if(o.contains("presenzaOggi")){
                            Gson j = new Gson();
                            Studente s = j.fromJson(o, Studente.class);
                            StudentListaCorsi.putExtra("studente", s);
                            startActivity(StudentListaCorsi);
                        } else {
                            Toast.makeText(getApplicationContext(), "I dati inseriti non sono corretti", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"fallito",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrazione);
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
