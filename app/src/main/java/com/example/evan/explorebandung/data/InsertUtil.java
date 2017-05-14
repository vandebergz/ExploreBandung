package com.example.evan.explorebandung.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evan on 5/13/17.
 */

public class InsertUtil {
    public static void insertData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of places
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        //cv.put(WisataContract.WisataEntry.COLUMN_WISATA_ID, "Wisata");
        cv.put(WisataContract.WisataEntry.COLUMN_PLACE, "Farm House");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENDATE, "Senin - Jumat");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENTIME, "09.00 - 21.00");
        //cv.put(WisataContract.WisataEntry.COLUMN_DESKRIPSI, "Tempat wisata di Bandung");
        cv.put(WisataContract.WisataEntry.COLUMN_ADDRESS, "Jl. Raya Lembang No.108, " +
                "Gudangkahuripan, Lembang, Kabupaten Bandung Barat, Jawa Barat 40391");
        cv.put(WisataContract.WisataEntry.COLUMN_CONTACT, "Wisata");
        list.add(cv);

        cv = new ContentValues();
        //cv.put(WisataContract.WisataEntry.COLUMN_WISATA_ID, "Wisata");
        cv.put(WisataContract.WisataEntry.COLUMN_PLACE, "Dago Dreampark");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENDATE, "Senin - Jumat");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENTIME, "09.00 - 21.00");
        //cv.put(WisataContract.WisataEntry.COLUMN_DESKRIPSI, "Tempat wisata di Bandung");
        cv.put(WisataContract.WisataEntry.COLUMN_ADDRESS, "Jl. Dago Giri KM 2.2, Mekarwangi, " +
                "Lembang, Kabupaten Bandung Barat, Jawa Barat 40135");
        cv.put(WisataContract.WisataEntry.COLUMN_CONTACT, "Wisata");
        list.add(cv);

        cv = new ContentValues();
        //cv.put(WisataContract.WisataEntry.COLUMN_WISATA_ID, "Wisata");
        cv.put(WisataContract.WisataEntry.COLUMN_PLACE, "Lodge Maribaya");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENDATE, "Senin - Jumat");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENTIME, "09.00 - 21.00");
        //cv.put(WisataContract.WisataEntry.COLUMN_DESKRIPSI, "Tempat wisata di Bandung");
        cv.put(WisataContract.WisataEntry.COLUMN_ADDRESS, "Jalan Maribaya "+
                "No. 149/252, RT. 03 / RW. 15, Babakan Gentong, Cibodas, Lembang, Cibodas, Lembang,"
                + " Kabupaten Bandung Barat, Jawa Barat 40391");
        cv.put(WisataContract.WisataEntry.COLUMN_CONTACT, "Wisata");
        list.add(cv);

        cv = new ContentValues();
        //cv.put(WisataContract.WisataEntry.COLUMN_WISATA_ID, "Wisata");
        cv.put(WisataContract.WisataEntry.COLUMN_PLACE, "Paris Van Java");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENDATE, "Senin - Jumat");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENTIME, "09.00 - 21.00");
        //cv.put(WisataContract.WisataEntry.COLUMN_DESKRIPSI, "Tempat wisata di Bandung");
        cv.put(WisataContract.WisataEntry.COLUMN_ADDRESS, "Jl. Sukajadi No. 131 - 139, Cipedes, "+
                "Sukajadi, Kota Bandung, Jawa Barat 40162");
        cv.put(WisataContract.WisataEntry.COLUMN_CONTACT, "Mall");
        list.add(cv);

        cv = new ContentValues();
        //cv.put(WisataContract.WisataEntry.COLUMN_WISATA_ID, "Wisata");
        cv.put(WisataContract.WisataEntry.COLUMN_PLACE, "Kawah Putih");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENDATE, "Senin - Jumat");
        //cv.put(WisataContract.WisataEntry.COLUMN_OPENTIME, "09.00 - 21.00");
        //cv.put(WisataContract.WisataEntry.COLUMN_DESKRIPSI, "Tempat wisata di Bandung");
        cv.put(WisataContract.WisataEntry.COLUMN_ADDRESS, "Jalan Raya Ciwidey Patengan Km 11, "+
                "Lebakmuncang, Ciwidey, Bandung, Jawa Barat 40972");
        cv.put(WisataContract.WisataEntry.COLUMN_CONTACT, "Wisata");
        list.add(cv);

        //insert all places in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (WisataContract.WisataEntry.TABLE_NAME, null, null);

            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(WisataContract.WisataEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }

    }
}
