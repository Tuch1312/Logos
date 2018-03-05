package com.dettofatto.logos.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.dettofatto.logos.R;
import com.jackandphantom.circularprogressbar.CircleProgressbar;

import java.util.ArrayList;

/**
 * Created by Tuch on 08/02/18.
 */

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
    //questa parte di codece risolve il problema di mostrare la circular progressBar buggata
        CircleProgressbar c = view.findViewById(R.id.cerchio) ;
    Display display = getActivity().getWindowManager().getDefaultDisplay();
    DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
    float density  = getResources().getDisplayMetrics().density;
    float dpHeight = outMetrics.heightPixels / density;
    float dpWidth  = outMetrics.widthPixels / density;
        c.setLayoutParams(new LinearLayout.LayoutParams((int)dpHeight,(int)dpWidth));


    LinearLayout lv = view.findViewById(R.id.list);
    ArrayList<String> m = new ArrayList<String>();
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
        m.add("weila");
    ArrayAdapter<String> aa = new ArrayAdapter<String>(getContext(), R.layout.row_dash , m);
        for(int i = 0; i<m.size();i++) {
            lv.addView(aa.getView(i, null, lv));
        }


    }

}
