package com.dettofatto.logos;

import android.app.Activity;
import android.os.Bundle;
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

public class Registration extends Activity {

    final String BASE_URL = "http://18.194.218.75:8080/";
    Retrofit r =  new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

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
}
