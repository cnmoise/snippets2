package com.example.claud.simplefragmentkiller;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupViewPager(mPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        SectionsPagerAdapter mPageAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);

        mPageAdapter.addFragment(new MyFragment(), "HOME",0);
        mPageAdapter.addFragment(new MyFragment(), "NEWS", 1);

        //viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(mPageAdapter);
    }
}
