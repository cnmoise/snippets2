package com.example.claud.dynamicfragmentkiller;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    List<Fragment> fragments;
    ArrayList<String> categories = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categories.add("1");
        categories.add("2");
        categories.add("3");
        fragments = buildFragments();

        ViewPager mPager = (ViewPager) findViewById(R.id.pager);
        MyFragmentPageAdapter mPageAdapter = new MyFragmentPageAdapter(this, getSupportFragmentManager(), fragments, categories);
        mPager.setAdapter(mPageAdapter);

//Add a new Fragment to the list with bundle
        Bundle bundle = new Bundle();
        bundle.putInt("position", 1);
        String title = "asd";

//        Fragment activeFrag = new Fragment();
//        activeFrag.setArguments(bundle);

        mPageAdapter.add(Fragment.class, title, bundle);

        Log.d("Claude", "New Fragment Added: " + Fragment.class + " " + title);
        mPageAdapter.notifyDataSetChanged();

        Fragment mContent = getSupportFragmentManager().findFragmentByTag("asd");
        //(getArguments().getString("msg"));
        Log.d("Claude", "mContent Arguments: " + mContent.getArguments().getInt("position"));
    }

    private List<android.support.v4.app.Fragment> buildFragments() {
        List<android.support.v4.app.Fragment> fragments = new ArrayList<android.support.v4.app.Fragment>();
        for(int i = 0; i<categories.size(); i++) {
            Bundle b = new Bundle();
            b.putInt("position", i);
            fragments.add(Fragment.instantiate(this,MyPagerFragment.class.getName(),b));
        }

        return fragments;
    }
}
