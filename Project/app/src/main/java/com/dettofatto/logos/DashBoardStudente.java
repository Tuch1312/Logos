package com.dettofatto.logos;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.jackandphantom.circularprogressbar.CircleProgressbar;

import java.util.ArrayList;

public class DashBoardStudente extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_studente);
        CircleProgressbar c = findViewById(R.id.cerchio);
        c.invalidate();

        //questa parte di codece risolve il problema di mostrare la circular progressBar buggata
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
        float density  = getResources().getDisplayMetrics().density;
        float dpHeight = outMetrics.heightPixels / density;
        float dpWidth  = outMetrics.widthPixels / density;
        c.setLayoutParams(new LinearLayout.LayoutParams((int)dpHeight,(int)dpWidth));


        LinearLayout lv = findViewById(R.id.list);
        ArrayList<String>  m = new ArrayList<String>();
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
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getApplicationContext(), R.layout.row_dash , m);
        for(int i = 0; i<m.size();i++){
            lv.addView(aa.getView(i,null,lv));

        }


    }
}
