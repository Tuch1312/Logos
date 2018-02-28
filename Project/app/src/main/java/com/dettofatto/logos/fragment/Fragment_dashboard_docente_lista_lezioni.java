package com.dettofatto.logos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ListView;

import com.dettofatto.logos.PresenzeAssenze;
import com.dettofatto.logos.R;
import com.dettofatto.logos.adapter.AdapterListaPresenze;


public class Fragment_dashboard_docente_lista_lezioni extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_dashboard_docente_lista_lezioni, container, false);

        return V;
    }

    public void onViewCreated(View view){
        final ListView lv = view.findViewById(R.id.listaPresAss);
        Intent listapresass = new Intent(getActivity(), PresenzeAssenze.class);
        startActivity(listapresass);
    }

}
