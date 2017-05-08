package com.ajaysinghdewari.sqlitesample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created by Ajay on 08-05-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // All Static variables

    private static final String FILE_DIR = "appname";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "appNameDBManager";

    //table name
    protected static final String TABLE_USERS = "users";

    //table Columns names
    protected static final String KEY_ID = "id";
    protected static final String KEY_NAME = "f_name";
    protected static final String KEY_LAST_NAME = "l_name";
    protected static final String KEY_AGE = "age";


    public DBHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        super(context, Environment.getExternalStorageDirectory()
                + File.separator + FILE_DIR
                + File.separator + DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_LAST_NAME + " TEXT,"
                + KEY_AGE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(sqLiteDatabase);
    }
}
