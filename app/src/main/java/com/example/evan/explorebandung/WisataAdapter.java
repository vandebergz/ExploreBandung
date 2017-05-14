package com.example.evan.explorebandung;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evan.explorebandung.data.WisataContract;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    /**
     * Constructor using the context and the db cursor
     *
     * @param context the calling context/activity
     * @param cursor  the db cursor with waitlist data to display
     */
    public WisataAdapter(Context context, Cursor cursor) {
        this.mContext = context;
        this.mCursor = cursor;
    }

    @Override
    public WisataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.wisata_list, parent, false);
        return new WisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WisataViewHolder holder, int position) {
        // COMPLETED (5) Move the cursor to the passed in position, return if moveToPosition returns false
        // Move the mCursor to the position of the item to be displayed
        if (!mCursor.moveToPosition(position))
            return; // bail if returned null
        // COMPLETED (6) Call getString on the cursor to get the guest's name
        String name = mCursor.getString(mCursor.getColumnIndex(WisataContract.WisataEntry.COLUMN_PLACE));
        // COMPLETED (7) Call getInt on the cursor to get the party size
        String wisataId = mCursor.getString(mCursor.getColumnIndex(WisataContract.WisataEntry.COLUMN_PLACE));
        // COMPLETED (8) Set the holder's nameTextView text to the guest's name
        // Display the guest name
        holder.nameTextView.setText(name);
        // COMPLETED (9) Set the holder's partySizeTextView text to the party size
        // Display the party count
        holder.partySizeTextView.setText(wisataId);
    }

    @Override
    public int getItemCount() {
        // COMPLETED (4) Update the getItemCount to return the getCount of the cursor
        return mCursor.getCount();
    }

    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class WisataViewHolder extends RecyclerView.ViewHolder {

        // Will display the guest name
        TextView nameTextView;
        // Will display the party size number
        TextView partySizeTextView;

        public WisataViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            partySizeTextView = (TextView) itemView.findViewById(R.id.id_text_view);
        }
    }
}
