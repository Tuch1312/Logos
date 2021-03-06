package com.dettofatto.logos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dettofatto.logos.R;
import com.dettofatto.logos.RetroInterfaces.RetroLister;
import com.dettofatto.logos.RetrofitSingleton;
import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Lezione;
import com.google.gson.Gson;
import com.jackandphantom.circularprogressbar.CircleProgressbar;

import java.util.List;

import retrofit2.Callback;

import static android.content.ContentValues.TAG;

/**
 * Created by Tuch on 08/02/18.
 */

public class Fragment_dashboard_docente_corso_dash extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_corso_dash, container, false);

        return V;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Bundle b = getArguments();
        final Docente d = (Docente) b.getSerializable("Docente");
        final Corso corso = (Corso) b.getSerializable("Corso");
        Gson gson = new Gson();
        String g = gson.toJson(corso);



    }
}