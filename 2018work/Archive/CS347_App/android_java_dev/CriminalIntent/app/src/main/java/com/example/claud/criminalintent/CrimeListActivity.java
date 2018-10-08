package com.example.claud.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by claud on 2/15/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
