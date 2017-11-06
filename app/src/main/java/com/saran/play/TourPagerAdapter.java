package com.saran.play;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by core I5 on 11/2/2017.
 */

public class TourPagerAdapter extends FragmentStatePagerAdapter {
    public TourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return new TourCreateFragment();
            }
            case 1:{
                return new TourViewFragment();
            }
            case 2:{
                return new TourSyncFragment();
            }
            default:{
                return null;
            }
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
