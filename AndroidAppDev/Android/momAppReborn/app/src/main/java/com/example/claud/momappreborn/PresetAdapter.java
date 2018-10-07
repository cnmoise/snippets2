package com.example.claud.momappreborn;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.claud.momappreborn.PresetListActivity.listItemFocused;

public class PresetAdapter extends RecyclerView.Adapter<PresetAdapter.CustomViewHolder> {

    private static final String TAG = PresetAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener;
    final private ListItemFocusChangeListener mOnFocusListener;

    private ArrayList<TimerPresetRow> mPresetTimerList;
    int row_index = -1;



    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
    public interface ListItemFocusChangeListener {
        void onListItemFocusChange(View v, boolean b);
    }

    public PresetAdapter(ArrayList<TimerPresetRow> mPresetTimerList, ListItemClickListener listener, ListItemFocusChangeListener focusListener) {
        this.mPresetTimerList = mPresetTimerList;
        mOnClickListener = listener;
        mOnFocusListener = focusListener;

    }
    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     *                  can use this viewType integer to provide a different layout. See
     *                  {@link android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)}
     *                  for more details.
     * @return A new SubmittedTaskRowViewHolder that holds the View for each list item
     */
    @Override
    public CustomViewHolder onCreateViewHolder (ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.preset_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    /**
     * This method simply returns the number of mPresetTimerList to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of mPresetTimerList available in our forecast
     */
    @Override
    public int getItemCount() {
        return mPresetTimerList.size();
    }

    /**
     * Cache of the children views for a list item.
     */
    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnFocusChangeListener{

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView listItemTimerValue;
        TextView listItemDescription;
        //ConstraintLayout mBackground;

        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *
         */
        public CustomViewHolder(View itemView) {
            super(itemView);

            listItemTimerValue = (TextView) itemView.findViewById(R.id.tv_item_timer_value);
            listItemDescription = (TextView) itemView.findViewById(R.id.tv_item_title);

            itemView.setOnClickListener(this);
            itemView.setOnFocusChangeListener(this);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         *
         */
        void bind(int position) {
            listItemTimerValue.setText(mPresetTimerList.get(position).getTimeAsText());
            listItemDescription.setText(mPresetTimerList.get(position).getTimerTitle());
        }

        @Override
        public void onClick(View view){
            int clickedPosition = getAdapterPosition();
//            row_index=clickedPosition;
//
//            if(row_index=clickedPosition)
//            view.setSelected(false);
//
//            if(previouslyClickedItemIndex == clickedPosition){
//                view.setSelected(true);
//            }
//            else{
//                view.setSelected(false);
//            }
//            Log.d("Claude PresetAdapt", "clickedPosition " + clickedPosition);

            mOnClickListener.onListItemClick(clickedPosition);
        }


        @Override
        public void onFocusChange(View view, boolean hasFocus) {
            int focusedPosition = getAdapterPosition();

//            if(focusedPosition == 0){
//                hasFocus = false;
//            }
            listItemFocused = focusedPosition;
//
//            view.setSelected(false);
//
//            if(previouslyClickedItemIndex == focusedPosition){
//                view.setSelected(true);
//            }
//            else{
//                view.setSelected(false);
//            }

            Log.d("Claude PresetAdapt", "onFocusChange focusedPosition: " + focusedPosition +" hasFocus " +hasFocus + " listItemFocused " + listItemFocused);



            //A callback
            mOnFocusListener.onListItemFocusChange(view, hasFocus);
        }
    }
}
