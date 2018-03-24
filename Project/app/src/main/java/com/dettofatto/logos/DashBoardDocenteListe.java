package com.dettofatto.logos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.ListView;


import com.dettofatto.logos.adapter.SectionsPagerAdapter;

import com.dettofatto.logos.entities.Docente;
import com.dettofatto.logos.entities.Studente;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_lista_corsi;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_lista_lezioni;
import com.getbase.floatingactionbutton.AddFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashBoardDocenteListe extends AppCompatActivity {

    DrawerLayout dl;








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


        dl = findViewById(R.id.drawer_dashboard_docente_liste);

        //this allow to create and set a toolbar because the theme setted as default doesn't have an action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_dashboard_docente_liste);
        setSupportActionBar(myToolbar);

        //this let us use the menu icon on the top left of the activity
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        //listener of the item inside the drawer layout
        NavigationView navigationView = findViewById(R.id.nav_view_dashboard_docente_liste);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        dl.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });



        Intent i = getIntent();
        final Docente d = (Docente) i.getSerializableExtra("docente");
        Bundle b = new Bundle();
        b.putSerializable("docente", d);
        fragment1.setArguments(b);
        fragment2.setArguments(b);

        //Aggiungo i fragment alla lista
        fragmentList.add(fragment2);
        fragmentList.add(fragment1);

       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragmentList);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        final com.getbase.floatingactionbutton.FloatingActionsMenu menu = findViewById(R.id.menuFab);


        final int ShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    menu.animate()
                            .alpha(0f)
                            .setDuration(ShortAnimationDuration)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    menu.setVisibility(View.GONE);
                                }
                            });
                } else {
                    menu.setAlpha(0f);
                    menu.setVisibility(View.VISIBLE);
                    menu.animate()
                            .alpha(1f)
                            .setDuration(ShortAnimationDuration)
                            .setListener(null);
                }
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



        AddFloatingActionButton fab = findViewById(R.id.fab);
        final Intent toCreaCorso = new Intent(this, CreaCorso.class);
        toCreaCorso.putExtra("Docente", d);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mViewPager.getCurrentItem()==1)
                    startActivity(toCreaCorso);
            }
        });
        final Intent toModificaCorso = new Intent(this, ModificaCorso.class);
        toModificaCorso.putExtra("Docente", d);
        AddFloatingActionButton fab1 = findViewById(R.id.fab1);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toModificaCorso);
            }
        });
        final Intent toEliminaCorso = new Intent(this, EliminaCorso.class);
        toEliminaCorso.putExtra("Docente", d);
        AddFloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toEliminaCorso);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
