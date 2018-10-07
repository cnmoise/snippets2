package com.example.claud.momappreborn;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.util.Log;

public class ControlRoom extends AppCompatActivity implements TimerFragment.OnSubmitListener {

    private boolean globalTimerStatus;
    private CountDownTimer globalCountDownTimer;

    private int[] imageResId = {
            R.drawable.ic_one,
            R.drawable.ic_two,
            R.drawable.ic_three };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_control_room);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SampleFragmentPagerAdapter pagerAdapter =
                new SampleFragmentPagerAdapter(getSupportFragmentManager(), ControlRoom.this);
        viewPager.setAdapter(pagerAdapter);

        //sets context to the activity we're currently in

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }



        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }
    }

    @Override
    public void onTimeSubmitted(Long mTimeElapsedInMillis, String taskTitle, String dateTaskSubmittedAsText) {
        Log.d("claude Main", "mTimeElapsedInMillis " + mTimeElapsedInMillis);
        Bundle bundle = new Bundle();
        bundle.putString("taskTitle", taskTitle);
        bundle.putString("dateTaskSubmitted", dateTaskSubmittedAsText);
        bundle.putLong("mTimeElapsedInMillis", mTimeElapsedInMillis);

        SummaryPageFragment activeFrag = new SummaryPageFragment();
        activeFrag.setArguments(bundle);

        //
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fr_summary_page_container, activeFrag, "SourceFragTag")
                .commit();
        Log.d("claude Main", "Transaction Made");
    }

}
