package com.dettofatto.logos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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


public class Login extends Activity {







    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);






        final Intent StudentListaCorsi= new Intent(this, StudenteListaCorsi.class );
        final Intent dashboardDocente = new Intent(this, DashBoardDocenteListe.class);
        final Intent registrazione = new Intent(this, Registration.class);

        final EditText editmail = findViewById(R.id.editText);
        final EditText editpassword = findViewById(R.id.editText2);
        Button button = findViewById(R.id.Button);
        Button reg = findViewById(R.id.reg);
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
                        if(o.contains("oreDaTenere")){
                            Gson j = new Gson();
                            Docente d = j.fromJson(o, Docente.class);
                            dashboardDocente.putExtra("docente", d);
                            startActivity(dashboardDocente);
                        }

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

}
