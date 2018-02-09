package com.dettofatto.logos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dettofatto.logos.adapter.SectionsPagerAdapter;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_corso_dash;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_corso_lezioni;

import java.util.ArrayList;
import java.util.List;

public class DashboardDocenteCorsi extends AppCompatActivity {

    //Adapter
    private SectionsPagerAdapter mSectionsPagerAdapter;
    //Viewpager
    private ViewPager mViewPager;
    //Fragment
    static List<Fragment> fragmentList = new ArrayList<Fragment>();
    static Fragment_dashboard_docente_corso_dash fragment1 = new Fragment_dashboard_docente_corso_dash();
    static Fragment_dashboard_docente_corso_lezioni fragment2 = new Fragment_dashboard_docente_corso_lezioni();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_docente_corsi);

        //Aggiungo i fragment alla lista
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);

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