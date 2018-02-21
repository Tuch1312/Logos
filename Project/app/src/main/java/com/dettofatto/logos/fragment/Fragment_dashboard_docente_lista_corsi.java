package com.dettofatto.logos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.Toast;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetroInterfaces.RetroPersona;
import com.dettofatto.logos.entities.Corso;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Fragment_dashboard_docente_lista_corsi extends Fragment {

    final String BASE_URL = "http://18.194.218.75:8080/";
    Retrofit r =  new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_lista_corsi, container, false);



        RetroLister rv = r.create(RetroLister.class);
        Call<List<Corso>> c = rv.getCorsiPerDocente();
        c.enqueue(new Callback<List<Corso>>() {
            @Override
            public void onResponse(Call<List<Corso>> call, Response<List<Corso>> response) {
                List<Corso> lista = response.body();
            }

            @Override
            public void onFailure(Call<List<Corso>> call, Throwable t) {

            }
        });

        return V;
    }

}
