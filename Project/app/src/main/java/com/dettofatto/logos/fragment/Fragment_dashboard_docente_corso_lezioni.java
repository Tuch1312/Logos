package com.dettofatto.logos.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dettofatto.logos.R;

/**
 * Created by Tuch on 08/02/18.
 */

public class Fragment_dashboard_docente_corso_lezioni extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_corso_lezioni, container, false);

        return V;
    }
}
