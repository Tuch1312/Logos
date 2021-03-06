package com.dettofatto.logos.fragment;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Lezione;
import com.dettofatto.logos.entities.Studente;
import com.google.gson.Gson;
import com.jackandphantom.circularprogressbar.CircleProgressbar;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Tuch on 08/02/18.
 */

class ArgomentiStudenteAdapter extends ArrayAdapter<Lezione> {
    public ArgomentiStudenteAdapter(Context context, List<Lezione> listaLezioni) {
        super(context, 0, listaLezioni);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Lezione lezione = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_argomento, parent, false);
        }
        // Lookup view for data population
        TextView argomento = convertView.findViewById(R.id.argomento);
        // Populate the data into the template view using the data object
        argomento.setText(lezione.getArgomenti());
        // Return the completed view to render on screen
        return convertView;
    }


}









public class Fragment_dashbaord_studente_dash extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashbaord_studente_dash, container, false);

        return V;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Bundle b = getArguments();
        Corso corso = (Corso) b.getSerializable("corso");
        Gson j = new Gson();
        String g = j.toJson(corso);


        ImageView iv = view.findViewById(R.id.immagine);
        Picasso.get().load("http://18.194.218.75/assets/img/faces/christian.jpg").fit().centerCrop().into(iv);

        TextView titolo = view.findViewById(R.id.dashboard_title);
        titolo.setText(""+corso.getTitolo());
        TextView oreTotali = view.findViewById(R.id.ore_totali);
        oreTotali.setText("Ore totali: "+corso.getOreTotali());
        TextView oreTrascorse = view.findViewById(R.id.ore_trascorse);
        oreTrascorse.setText("Ore trascorse: "+corso.getOreTrascorse());
        TextView lezione = view.findViewById(R.id.lezione);
        lezione.setText("Lezione n: "+corso.getLezioneCorrente());
        TextView docente = view.findViewById(R.id.docente);
        //non riesco a recuperare il docente del corso
        //docente.setText(""+d.getNome());
        TextView oraInizio = view.findViewById(R.id.ora_inizio);
        oraInizio.setText("Ora inizio: "+corso.getOraInizioLezioni());
        TextView aula = view.findViewById(R.id.aula);
        aula.setText("Aula :"+corso.getSede());
        TextView ore = view.findViewById(R.id.ore);
        ore.setText(""+corso.getContatoreGiorniInterno());



        RetroLister rv = RetrofitSingleton.r.create(RetroLister.class);
        final ListView lv = view.findViewById(R.id.lista_argomenti);
        retrofit2.Call<List<Lezione>> call = rv.getLezioniPerCorso(g);
        call.enqueue(new Callback<List<Lezione>>(){
            @Override
            public void onResponse(retrofit2.Call<List<Lezione>> call, Response<List<Lezione>> response) {
                List<Lezione>lista = response.body();
                ArgomentiStudenteAdapter argomentiAdapter = new ArgomentiStudenteAdapter(getContext(), lista);
                lv.setAdapter(argomentiAdapter);

                int totalHeight = 0;
                for (int i = 0, len = argomentiAdapter.getCount(); i < len; i++) {
                    View listItem = argomentiAdapter.getView(i, null, lv);
                    listItem.measure(0, 0);
                    totalHeight += listItem.getMeasuredHeight();
                }
                ViewGroup.LayoutParams params = lv.getLayoutParams();
                params.height = totalHeight;
                lv.setLayoutParams(params);
                lv.setFocusable(false);
                lv.setFocusableInTouchMode(false);



            }

            @Override
            public void onFailure(retrofit2.Call<List<Lezione>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }

}
