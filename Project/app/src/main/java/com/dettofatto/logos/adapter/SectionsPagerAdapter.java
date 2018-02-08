package com.dettofatto.logos.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dettofatto.logos.fragment.Fragment1;
import com.dettofatto.logos.fragment.Fragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    static List<Fragment> fragmentList = new ArrayList<Fragment>();
    static Fragment1 fragment1 = new Fragment1();
    static Fragment2 fragment2 = new Fragment2();


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
    }



    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }
}