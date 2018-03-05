package com.dettofatto.logos.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dettofatto.logos.fragment.Fragment_dashboard_docente_corso_dash;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_corso_lezioni;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_lista_corsi;
import com.dettofatto.logos.fragment.Fragment_dashboard_docente_lista_lezioni;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tuch on 08/02/18.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    static List<Fragment> fragmentList = new ArrayList<Fragment>();



    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
       this.fragmentList = fragmentList;
    }


    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}