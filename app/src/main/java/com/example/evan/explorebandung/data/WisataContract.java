package com.example.evan.explorebandung.data;

import android.provider.BaseColumns;

/**
 * Created by evan on 5/13/17.
 */

public class WisataContract {

    public static final class WisataEntry implements BaseColumns {

        public static final String TABLE_NAME = "tempat_wisata";

        public static final String COLUMN_OPENDATE = "opendate";

        public static final String COLUMN_WISATA_ID = "wisata_id";

        public static final String COLUMN_DESKRIPSI = "deskripsi";

        public static final String COLUMN_OPENTIME = "opentime";

        public static final String COLUMN_ADDRESS = "address";

        public static final String COLUMN_CONTACT = "contact";

        public static final String COLUMN_PLACE = "place";
    }
}
