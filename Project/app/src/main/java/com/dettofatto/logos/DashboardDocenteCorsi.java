package com.dettofatto.logos;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dettofatto.logos.adapter.SectionsPagerAdapter;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_corso_dash;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_corso_lezioni;

import java.util.ArrayList;
import java.util.List;

public class DashboardDocenteCorsi extends AppCompatActivity {


    DrawerLayout dl;

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


        dl = findViewById(R.id.drawer_dashboard_docente_corsi);

        //this allow to create and set a toolbar because the theme setted as default doesn't have an action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_dashboard_docente_corsi);
        setSupportActionBar(myToolbar);

        //this let us use the menu icon on the top left of the activity
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        //listener of the item inside the drawer layout
        NavigationView navigationView = findViewById(R.id.nav_view_dashboard_docente_corsi);
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




        //Aggiungo i fragment alla lista
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fragmentList);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        final com.getbase.floatingactionbutton.FloatingActionsMenu menuCorso = findViewById(R.id.menuFabcorso);
        final com.getbase.floatingactionbutton.FloatingActionsMenu menuLezioni = findViewById(R.id.menuFabLezioni);

        final int ShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position == 0){
                    menuLezioni.animate()
                            .alpha(0f)
                            .setDuration(ShortAnimationDuration)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    menuLezioni.setVisibility(View.GONE);
                                }
                            });
                    menuCorso.setAlpha(0f);
                    menuCorso.setVisibility(View.VISIBLE);
                    menuCorso.animate()
                            .alpha(1f)
                            .setDuration(ShortAnimationDuration)
                            .setListener(null);

                } else {
                    menuLezioni.setAlpha(0f);
                    menuLezioni.setVisibility(View.VISIBLE);
                    menuLezioni.animate()
                            .alpha(1f)
                            .setDuration(ShortAnimationDuration)
                            .setListener(null);
                    menuCorso.animate()
                            .alpha(0f)
                            .setDuration(ShortAnimationDuration)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    menuCorso.setVisibility(View.GONE);
                                }
                            });

                }
            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        com.getbase.floatingactionbutton.AddFloatingActionButton fabCreaLezione = findViewById(R.id.fabCreaLezione);
        com.getbase.floatingactionbutton.AddFloatingActionButton fabModificaLezione = findViewById(R.id.fabModificaLezione);
        com.getbase.floatingactionbutton.AddFloatingActionButton fabEliminaLezione = findViewById(R.id.fabEliminaLezione);
        final Intent toCreaLezione = new Intent(this, CreaLezione.class);
        final Intent toModificaLezione = new Intent(this, ListaModificaLezione.class);
        final Intent toEliminaLezione = new Intent(this, EliminaLezione.class);
        fabCreaLezione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toCreaLezione);
            }
        });
        fabModificaLezione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toModificaLezione);
            }
        });
        fabEliminaLezione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toEliminaLezione);
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