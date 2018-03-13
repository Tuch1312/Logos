package com.dettofatto.logos;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroPersona;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registration extends AppCompatActivity {

    final String BASE_URL = "http://18.194.218.75:8080/";
    Retrofit r =  new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    DrawerLayout dl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        dl = findViewById(R.id.drawer_registration);
        //this allow to create and set a toolbar because the theme setted as default doesn't have an action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_reg);
        setSupportActionBar(myToolbar);

        //this let us use the menu icon on the top left of the activity
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        //listener of the item inside the drawer layout
        NavigationView navigationView = findViewById(R.id.nav_view_reg);
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


        final EditText et = findViewById(R.id.editText);
        final EditText et2 = findViewById(R.id.editText2);
        final EditText et3 = findViewById(R.id.editText3);
        final EditText et4 = findViewById(R.id.editText4);
        final RadioGroup rg = findViewById(R.id.radioGroup);
        Button registrati = findViewById(R.id.registrati);
        final RadioButton r3 = findViewById(R.id.radioButton3);


        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDocente=false;
                if(r3.isChecked()) {
                    isDocente=true;
                }


                        RetroPersona rp = r.create(RetroPersona.class);
                        Call<Boolean> p =  rp.registrazione(et3.getText().toString(),et4.getText().toString(),et.getText().toString(),et2.getText().toString(), isDocente);
                        p.enqueue(new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                if(response.body().booleanValue()==true) {
                                    Toast.makeText(getApplicationContext(), "Registrato", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "errore", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                Toast.makeText(getApplicationContext(),"fallito",Toast.LENGTH_LONG).show();
                            }
                        });
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
