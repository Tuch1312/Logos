package com.dettofatto.logos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.dettofatto.logos.RetroInterfaces.RetroPersona;
import com.dettofatto.logos.entities.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends Activity {

    public static final String BASE_URL = "http://localhost:8080";
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();
    Retrofit r =  new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        final Persona wowo = new Persona();
        RetroPersona rp = r.create(RetroPersona.class);
        Call<Persona> p =  rp.login();
        p.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                wowo.setNome(response.body().getNome());
                Toast.makeText(getApplicationContext(),wowo.getNome(),Toast.LENGTH_LONG);
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fallito",Toast.LENGTH_LONG);
            }
        });
    }

}
