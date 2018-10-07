package com.example.claud.fragmentkiller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by claud on 8/16/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private TextProvider mProvider;
    private long baseId = 0;

    public MyPagerAdapter(FragmentManager fm, TextProvider provider) {
        super(fm);
        this.mProvider = provider;
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.newInstance(mProvider.getTextForPosition(position));
    }

    @Override
    public int getCount() {
        return mProvider.getCount();
    }


    //this is called when notifyDataSetChanged() is called
    @Override
    public int getItemPosition(Object object) {
        // refresh all fragments when data set changed
        return PagerAdapter.POSITION_NONE;
    }


    @Override
    public long getItemId(int position) {
        // give an ID different from position when position has been changed
        return baseId + position;
    }

    /**
     * Notify that the position of a fragment has been changed.
     * Create a new ID for each position to force recreation of the fragment
     * @param n number of items which have been changed
     */
    public void notifyChangeInPosition(int n) {
        // shift the ID returned by getItemId outside the range of all previous fragments
        baseId += getCount() + n;
    }
}
