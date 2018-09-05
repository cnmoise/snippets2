package com.example.claud.momappreborn;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Integer.parseInt;

/**
 * Created by claud on 8/15/2018.
 */

public class SummaryPageFragment extends Fragment implements SubmittedTaskAdapter.ListItemClickListener, SubmittedTaskAdapter.ListItemFocusChangeListener {
    private static final String TAG = "Claude pFrag";
    private static final String LifeCycleTag = TAG + " Lifecycle";

    TextView mHomeTextView;
    RecyclerView mSubmittedTaskRecyclerView;
    SubmittedTaskAdapter mSubmittedTaskAdapter;
    private ArrayList<SubmittedTaskRow> mSubmittedTaskList = new ArrayList<SubmittedTaskRow>();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");


    public static long mTimeElapsedInMillisPage;
    public static long sTimeElapsedSum = 0;
    public long[] submittedTaskArray = new long[5];

    //new instances speak for themselves
    public static SummaryPageFragment newInstance(String text) {



    SummaryPageFragment f = new SummaryPageFragment();
    Bundle args = new Bundle();
    args.putString("msg", text);
    f.setArguments(args);

    return f;
}
    public static SummaryPageFragment newInstance(Bundle bundle) {
        SummaryPageFragment f = new SummaryPageFragment();
        Bundle args = new Bundle();
        args.putString("msg", "Testing Transactions");
        f.setArguments(bundle);
        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_summary_page, container, false);

        mHomeTextView= view.findViewById(R.id.tv_home);
        mSubmittedTaskRecyclerView = (RecyclerView) view.findViewById(R.id.rv_submitted_tasks);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mSubmittedTaskRecyclerView.setLayoutManager(layoutManager);
        mSubmittedTaskRecyclerView.setHasFixedSize(true);

        mSubmittedTaskAdapter = new SubmittedTaskAdapter(mSubmittedTaskList, this, this);
        mSubmittedTaskRecyclerView.setAdapter(mSubmittedTaskAdapter);


//        mSubmittedTaskList.add(STR);
//        mSubmittedTaskList.add(STR);
//        mSubmittedTaskList.add(STR);
//        mSubmittedTaskList.add(STR);
//        mSubmittedTaskList.add(STR);

        Fragment mContent = getFragmentManager().findFragmentByTag("SourceFragTag");
        if(mContent != null){
            String taskTitle = mContent.getArguments().getString("taskTitle");
            String dateTaskSubmittedAsText = mContent.getArguments().getString("dateTaskSubmittedAsText");
            Long TimeElapsedInMillis = mContent.getArguments().getLong("mTimeElapsedInMillis");

            Log.d(TAG, "Frag contents: \n"
                    + mContent.getArguments().getString("taskTitle")
                    + mContent.getArguments().getString("dateTaskSubmittedAsText")
                    + mContent.getArguments().getLong("mTimeElapsedInMillis")
                    );

            SubmittedTaskRow STR = new SubmittedTaskRow();
            STR.setTimerTitle(taskTitle);
//            try {
////                DateFormat.getDateTimeInstance().format(new Date());
//                Date date = format.parse(dateTaskSubmittedAsText);
////                System.out.println(date);
//                Log.d(TAG, "DateSet: " + date);
//                STR.setDateTaskSubmitted(date);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            STR.setTimeElapsed(TimeElapsedInMillis);

            mSubmittedTaskList.add(STR);

//            String mTimeElapsedInMillisAsString = mContent.getArguments().getString("params");
            loadData();
            boolean itemAdded = false;
            Long mTimeElapsedInMillisPage = mContent.getArguments().getLong("params");
            for (int j = 0; j < submittedTaskArray.length && itemAdded == false; j++){
                if(submittedTaskArray[j]== 0){
                    submittedTaskArray[j] = mTimeElapsedInMillisPage;
                    Log.d(TAG, "1st loopwatcher: " + j + " mTimeElapsedInMillisPage " + mTimeElapsedInMillisPage);
                    itemAdded = true;
                }
            }
            SumAllSubmittedTasks();

            mHomeTextView.setText("Time Elapsed: " + createReadableTime(sTimeElapsedSum));
        }
        else {
            Log.d(TAG, "mContentNull (pageFragment)");
        }

        return view;
    }

    private String createReadableTime(Long mTimeElapsedInMillisPage) {
        long seconds = mTimeElapsedInMillisPage / 1000 % 60;
        long minutes = mTimeElapsedInMillisPage / 60000 % 60;
        long hours = mTimeElapsedInMillisPage / 3600000;

        String timeElapsedFormatted = String.format(Locale.getDefault(),"%02d:%02d:%02d", hours, minutes, seconds);
        return timeElapsedFormatted;
    }

    private void SumAllSubmittedTasks(){

        for (int j = 0; j < submittedTaskArray.length; j++){
            if(submittedTaskArray[j]!= 0){
                sTimeElapsedSum += submittedTaskArray[j];
                Log.d(TAG, "2nd loopwatcher: " + j + " mTimeElapsedInMillisPage " + sTimeElapsedSum);
            }
        }
        saveData(sTimeElapsedSum);
    }

    private void saveData(long TimeElapsedSum){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putLong("elapsedSum", TimeElapsedSum);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("test", MODE_PRIVATE);
        sTimeElapsedSum = sharedPreferences.getLong("elapsedSum", 0);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifeCycleTag, "onCreate");


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LifeCycleTag, "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LifeCycleTag, "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LifeCycleTag, "onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LifeCycleTag, "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LifeCycleTag, "onDestroy");

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }

    @Override
    public void onListItemFocusChange(View v, boolean b) {

    }
}
