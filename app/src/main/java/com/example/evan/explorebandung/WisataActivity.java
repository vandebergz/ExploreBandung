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

import java.util.ArrayList;
import java.util.List;
import com.example.evan.explorebandung.data.DatabaseModel;

public class WisataActivity extends AppCompatActivity {

    WisataDbHelper helper;
    List<DatabaseModel> dbList;
    private WisataAdapter mAdapter;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        RecyclerView wisataRecyclerView;

        // Set local attributes to corresponding views
        wisataRecyclerView = (RecyclerView) this.findViewById(R.id.all_guests_list_view);

        // Set layout for the RecyclerView, because it's a list we are using the linear layout
        wisataRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // COMPLETED (2) Create a WisataDbHelper instance, pass "this" to the constructor
        // Create a DB helper (this will create the DB if run for the first time)
        WisataDbHelper dbHelper = new WisataDbHelper(this);

        helper = new WisataDbHelper(this);
        dbList= new ArrayList<DatabaseModel>();
        dbList = helper.getDataFromDB();

        mDb = dbHelper.getWritableDatabase();

        InsertUtil.insertData(mDb);

        Cursor cursor = getAllWisata();

        mAdapter = new WisataAdapter(this, dbList);

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