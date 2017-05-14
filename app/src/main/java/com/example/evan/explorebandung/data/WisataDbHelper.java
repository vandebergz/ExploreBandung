package com.example.evan.explorebandung.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by evan on 5/13/17.
 */

public class WisataDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "wisata.db";

    private static final int DATABASE_VERSION = 1;

    public WisataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*final String SQL_CREATE_WISATA_TABLE = "CREATE TABLE" + WisataContract.WisataEntry.TABLE_NAME + "(" +
                WisataContract.WisataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WisataContract.WisataEntry.COLUMN_WISATA_ID + "TEXT, " +
                WisataContract.WisataEntry.COLUMN_PLACE + "TEXT, " +
                WisataContract.WisataEntry.COLUMN_OPENDATE + "TEXT, " +
                WisataContract.WisataEntry.COLUMN_OPENTIME + "TEXT, " +
                WisataContract.WisataEntry.COLUMN_DESKRIPSI + "TEXT, " +
                WisataContract.WisataEntry.COLUMN_CONTACT + "TEXT, " +
                WisataContract.WisataEntry.COLUMN_ADDRESS + "TEXT);";*/
        final String SQL_CREATE_WISATA_TABLE = "CREATE TABLE " + WisataContract.WisataEntry.TABLE_NAME + " (" +
                WisataContract.WisataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WisataContract.WisataEntry.COLUMN_PLACE + " TEXT NOT NULL, " +
                WisataContract.WisataEntry.COLUMN_ADDRESS + " TEXT NOT NULL, " +
                WisataContract.WisataEntry.COLUMN_CONTACT + " TEXT NOT NULL" +
                "); ";
        sqLiteDatabase.execSQL(SQL_CREATE_WISATA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WisataContract.WisataEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
