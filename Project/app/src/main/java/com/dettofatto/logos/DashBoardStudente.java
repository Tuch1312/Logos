package com.dettofatto.logos;

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

import com.dettofatto.logos.entities.Corso;
import com.dettofatto.logos.entities.Studente;
import com.dettofatto.logos.fragment.Fragment_dashbaord_studente_dash;
import com.dettofatto.logos.fragment.Fragment_dashboard_studente_lezioni;

import java.util.ArrayList;
import java.util.List;

public class DashBoardStudente extends AppCompatActivity {

    DrawerLayout dl;

    //Adapter
    private SectionsPagerAdapter mSectionsPagerAdapter;
    //Viewpager
    private ViewPager mViewPager;
    //Fragment
    static List<Fragment> fragmentList = new ArrayList<Fragment>();
    static Fragment_dashbaord_studente_dash fragment1 = new Fragment_dashbaord_studente_dash();
    static Fragment_dashboard_studente_lezioni fragment2 = new Fragment_dashboard_studente_lezioni();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_studente);

        dl = findViewById(R.id.drawer_dashboard_studente);

        //this allow to create and set a toolbar because the theme setted as default doesn't have an action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_dashboard_studente);
        setSupportActionBar(myToolbar);

        //this let us use the menu icon on the top left of the activity
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);







        //listener of the item inside the drawer layout
        NavigationView navigationView = findViewById(R.id.nav_view_dashboard_studente);
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
        Studente s =(Studente) i.getSerializableExtra("studente");
        Corso c = (Corso) i.getSerializableExtra("corso");
        Bundle b = new Bundle();
        b.putSerializable("studente", s);
        b.putSerializable("corso", c);
        fragment1.setArguments(b);
        fragment2.setArguments(b);

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        //Carico i fragment nella lista
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);

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

    //Listener of the menu icon that open the drawer menu
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