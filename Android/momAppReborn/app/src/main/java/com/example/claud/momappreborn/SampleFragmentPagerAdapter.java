package com.example.claud.momappreborn;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by claud on 8/15/2018.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Home", "Timer", "Extra" };
    private int[] imageResId = { R.drawable.ic_one, R.drawable.ic_two,  R.drawable.ic_three };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

//    @Override
//    public Fragment getItem(int position) {
//        return SummaryPageFragment.newInstance(position + 1);
//    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return SummaryPageFragment.newInstance("SummaryPageFragment, Instance 1");
            case 1: return TimerFragment.newInstance("TimerFragment, Instance 1");
            case 2: return SecondFragment.newInstance("SecondFragment, Instance 1");
            default: return SummaryPageFragment.newInstance("SummaryPageFragment, Default");
        }
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        //TextView tv = (TextView) v.findViewById(R.id.tv_custom);
        //tv.setText(tabTitles[position]);
        ImageView img = (ImageView) v.findViewById(R.id.imgView);
        img.setImageResource(imageResId[position]);
        return v;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position

        //return tabTitles[position];
        return null;
    }
}
