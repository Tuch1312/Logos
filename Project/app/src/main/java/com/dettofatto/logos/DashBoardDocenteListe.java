package com.dettofatto.logos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;


import com.dettofatto.logos.adapter.SectionsPagerAdapter;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_lista_corsi;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_lista_lezioni;

import java.util.ArrayList;
import java.util.List;

public class DashBoardDocenteListe extends AppCompatActivity {

//Adapter
    private SectionsPagerAdapter mSectionsPagerAdapter;
    //Viewpager
    private ViewPager mViewPager;
    //Lista di fragment
    static List<Fragment> fragmentList = new ArrayList<Fragment>();
    static Fragment_dashboard_docente_lista_corsi fragment1 = new Fragment_dashboard_docente_lista_corsi();
    static Fragment_dashboard_docente_lista_lezioni fragment2 = new Fragment_dashboard_docente_lista_lezioni();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_liste_docente);

        final Intent presenzeAssenze = new Intent(this, PresenzeAssenze.class);
        startActivity(presenzeAssenze);


        //Aggiungo i fragment alla lista
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragmentList);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
}
