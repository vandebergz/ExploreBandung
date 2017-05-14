package com.example.evan.explorebandung;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.evan.explorebandung.R;
import com.example.evan.explorebandung.data.InsertUtil;
import com.example.evan.explorebandung.data.WisataContract;
import com.example.evan.explorebandung.data.WisataDbHelper;

public class WisataActivity extends AppCompatActivity {

    private WisataAdapter mAdapter;
    private SQLiteDatabase mDb;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        RecyclerView wisataRecyclerView;

        // Set local attributes to corresponding views
        wisataRecyclerView = (RecyclerView) this.findViewById(R.id.all_guests_list_view);

        // Set layout for the RecyclerView, because it's a list we are using the linear layout
        wisataRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // COMPLETED (2) Create a WaitlistDbHelper instance, pass "this" to the constructor
        // Create a DB helper (this will create the DB if run for the first time)
        WisataDbHelper dbHelper = new WisataDbHelper(this);

        // COMPLETED (3) Get a writable database reference using getWritableDatabase and store it in mDb
        // Keep a reference to the mDb until paused or killed. Get a writable database
        // because you will be adding restaurant customers

        mDb = dbHelper.getWritableDatabase();

        // COMPLETED (4) call insertFakeData in TestUtil and pass the database reference mDb
        //Fill the database with fake data
        InsertUtil.insertData(mDb);

        // COMPLETED (7) Run the getAllGuests function and store the result in a Cursor variable
        Cursor cursor = getAllWisata();

        // COMPLETED (12) Pass the resulting cursor count to the adapter
        // Create an adapter for that cursor to display the data
        mAdapter = new WisataAdapter(this, cursor);

        // Link the adapter to the RecyclerView
        wisataRecyclerView.setAdapter(mAdapter);
    }

    private Cursor getAllWisata() {
        return mDb.query(
                WisataContract.WisataEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                WisataContract.WisataEntry.COLUMN_PLACE
        );
    }
}
