package com.example.claud.fragmentkiller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements TextProvider {

    private Button mAdd;
    private Button mRemove;
    private Button mRemoveSpec;

    private ViewPager mPager;

    private MyPagerAdapter mAdapter;

    private ArrayList<String> mEntries = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEntries.add("pos 1");
        mEntries.add("pos 2");
        mEntries.add("pos 3");
        mEntries.add("pos 4");
        mEntries.add("pos 5");

        mAdd = (Button) findViewById(R.id.add);
        mRemove = (Button) findViewById(R.id.remove);
        mRemoveSpec = (Button) findViewById(R.id.remove_spec);
        mPager = (ViewPager) findViewById(R.id.pager);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewItem();
            }
        });

        mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeCurrentItem();
            }
        });
        mRemoveSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeSpecificItem();
            }
        });

        mAdapter = new MyPagerAdapter(this.getSupportFragmentManager(), this);

        mPager.setAdapter(mAdapter);

    }

    private void addNewItem() {
        mEntries.add("new item");
        mAdapter.notifyDataSetChanged();
    }

    private void removeSpecificItem() {
        //int position = mPager.getItemId(3);
        mEntries.remove(3);
        //Log.d("Hi", "Just removed: " + position);
        mAdapter.notifyDataSetChanged();
    }

    private void removeCurrentItem() {
        int position = mPager.getCurrentItem();
        mEntries.remove(position);
        Log.d("Hi", "Just removed: " + position);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public String getTextForPosition(int position) {
        Log.d("Hi", "position: " + mEntries.get(position));
        return mEntries.get(position);
    }
    @Override
    public int getCount() {
        return mEntries.size();
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

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
            Log.d("Hi", "NumPages: " + mProvider.getCount());
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

            Log.d("Hi", "Unique ID: " + baseId + position);
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


}