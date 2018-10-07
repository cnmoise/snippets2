package com.example.claud.momappreborn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by claud on 8/20/2018.
 */

public class PresetListActivity extends AppCompatActivity implements PresetAdapter.ListItemClickListener, PresetAdapter.ListItemFocusChangeListener{
    private RecyclerView mPresetList;
    private PresetAdapter mAdapter;
    private Toast mToast;
    private ArrayList<TimerPresetRow> mPresetTimerList = new ArrayList<TimerPresetRow>();
    public static int previouslyClickedItemIndex = -1;
    public static int mCurrentListItemIndex;
    public static int listItemFocused = -1;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_preset_list);

        //sets up RecyclerView & User Preset List
        mPresetList = (RecyclerView) findViewById(R.id.rv_presets);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mPresetList.setLayoutManager(layoutManager);
        mPresetList.setHasFixedSize(true);

        loadData();

        // The PresetAdapter is responsible for displaying each item in the list.
        mAdapter = new PresetAdapter(mPresetTimerList, this, this);
        mPresetList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//        if(listItemFocused != -1){
//            getMenuInflater().inflate(R.menu.menu_presettimerrow, menu);
//        }else{
//            getMenuInflater().inflate(R.menu.main, menu);
//        }
        getMenuInflater().inflate(R.menu.menu_all, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int clickedId = item.getItemId();
        //make sure id corresponds to an action
        //best to use a switch
        if(clickedId == R.id.action_add_preset){

            Intent i = new Intent(getApplicationContext(), NewPresetActivity.class);
            startActivityForResult(i, 1);
            return true;
        }
        if(clickedId == R.id.action_edit_preset){
            TimerPresetRow TPR = mPresetTimerList.get(listItemFocused);
            String timeAsText = TPR.getTimeAsText();
            String timerTitle = TPR.getTimerTitle();



            Intent i = new Intent(getApplicationContext(), NewPresetActivity.class);
            i.putExtra("timeAsText", timeAsText);
            i.putExtra("timerTitle", timerTitle);

            startActivityForResult(i, 1);

            return true;
        }
        if(clickedId == R.id.action_delete_preset){
            mToast = Toast.makeText(this, "listItemFocused: "+ listItemFocused + " will be removed", Toast.LENGTH_SHORT);
            mToast.show();
            Log.d("Claude PresetListAct", "listItemFocused: " + listItemFocused +" will be removed");


            mPresetTimerList.remove(listItemFocused);
            mAdapter.notifyDataSetChanged();
            saveData();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemFocusChange(View v, boolean b) {
//        mToast = Toast.makeText(this, "Congrats Item Focus achieved: ", Toast.LENGTH_SHORT);
//        mToast.show();
//        listItemFocused = ;
//        if(listItemFocused != -1){
//            invalidateOptionsMenu();
//        }
//        mCurrentListItemIndex = clickedItemIndex;


        invalidateOptionsMenu();
    }

    @Override
    public void onListItemClick(int clickedItemIndex){
        if(mToast!=null){
            mToast.cancel();
        }
        mCurrentListItemIndex = clickedItemIndex;
        //listItemClicks++;

//        mToast = Toast.makeText(this, "Item has actually been clicked listItemClicks: "+ listItemClicks + "listItemFocused " +listItemFocused, Toast.LENGTH_SHORT);
//        mToast.show();

        TimerPresetRow TPR = mPresetTimerList.get(clickedItemIndex);
        String timeAsText = TPR.getTimeAsText();
        String timerTitle = TPR.getTimerTitle();

        if(mCurrentListItemIndex==listItemFocused){
            mToast = Toast.makeText(this, "Item #"+ clickedItemIndex + " || listItemClicks: "+ mCurrentListItemIndex, Toast.LENGTH_SHORT);
            mToast.show();

            Intent i = new Intent();

            i.putExtra("timeAsText", timeAsText);
            i.putExtra("timerTitle", timerTitle);

            //listItemClicks=0;
            setResult(RESULT_OK, i);
            finish();
        } else {
            //deselects the item
            mToast = Toast.makeText(this, "Item #"+ previouslyClickedItemIndex + " deselected", Toast.LENGTH_SHORT);
            mToast.show();
            invalidateOptionsMenu();


            //previouslyClickedItemIndex = -1;
            //listItemClicks=0;
        }
            //Item has been selected

//
//            mToast = Toast.makeText(this, "Item #"+ clickedItemIndex + " selected"
//                    + " || listItemClicks: "+listItemClicks, Toast.LENGTH_SHORT);
//            mToast.show();
//            invalidateOptionsMenu();
//
//            previouslyClickedItemIndex= clickedItemIndex;
            //listItemClicks++;

//        } else if (listItemClicks==2 && clickedItemIndex == previouslyClickedItemIndex){
//            //item has been clicked while selected
//            mToast = Toast.makeText(this, "Item #"+ clickedItemIndex + " || listItemClicks: "+listItemClicks, Toast.LENGTH_SHORT);
//            mToast.show();
//
//            Intent i = new Intent();
//
//            i.putExtra("timeAsText", timeAsText);
//            i.putExtra("timerTitle", timerTitle);
//
//            listItemClicks=0;
//            setResult(RESULT_OK, i);
//            finish();
//




    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){

            //get Extras to create an entry
            String timeAsText = data.getStringExtra("timeAsText");
            String timerTitle = data.getStringExtra("timerTitle");
            TimerPresetRow TPR = new TimerPresetRow();
            TPR.setTimeAsText(timeAsText);
            TPR.setTimerTitle(timerTitle);

//            .add it as an entry into my array list
            mPresetTimerList.add(TPR);
            mAdapter.notifyDataSetChanged();

            saveData();
        }
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(mPresetTimerList);
        Log.d("Claude PresetListAct", "BEHOLD THE SAVING OF JSON: "+ json);

        editor.putString("task list", json);
        editor.apply();
    }

    //Populates list with entries from file
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);

        Type type = new TypeToken<ArrayList<TimerPresetRow>>() {}.getType();
        mPresetTimerList = gson.fromJson(json,type);
        Log.d("Claude PresetListAct", "BEHOLD THE LOADING OF JSON: "+ json);
    }


}
