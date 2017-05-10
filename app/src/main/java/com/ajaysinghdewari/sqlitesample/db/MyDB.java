package com.ajaysinghdewari.sqlitesample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.ajaysinghdewari.sqlitesample.models.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay on 01-03-2017.
 */

public class MyDB {

    private DBHelper mHelper;
    private Context context;

    public MyDB(Context context){
        this.context=context;
        mHelper=new DBHelper(context);
    }

    public void clearDB() {
        SQLiteDatabase db=mHelper.getWritableDatabase();
        try {
            db.delete(DBHelper.TABLE_USERS, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*=======================================CRUD Operations (Create, Read, Update and Delete)=====================================*/

    // Adding new user
    public void addUser(Users user) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        try {
            db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_NAME, user.get_name());
            values.put(DBHelper.KEY_LAST_NAME, user.get_last_name());
        values.put(DBHelper.KEY_AGE, user.get_age());

        // Inserting Row
        db.insert(DBHelper.TABLE_USERS, null, values);
            db.setTransactionSuccessful();
    }finally {
            db.endTransaction();
            db.close(); // Closing database connection
        }

    }


    // Getting single user
    public Users getUser(int id) {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        Cursor cursor = db.query(DBHelper.TABLE_USERS, new String[] { DBHelper.KEY_ID,DBHelper.KEY_AGE,
                        DBHelper.KEY_NAME, DBHelper.KEY_LAST_NAME }, DBHelper.KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Users user = new Users(Integer.parseInt(cursor.getString(0)),Integer.parseInt(cursor.getString(1)),
                cursor.getString(2), cursor.getString(3));
        cursor.close();
        return user;
    }

    // Getting All Users
    public List<Users> getAllUsers() {
        List<Users> userList = new ArrayList<Users>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBHelper.TABLE_USERS;

        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Toast.makeText(context, " length= "+cursor.getCount(), Toast.LENGTH_LONG).show();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Users contact = new Users();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_age(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_AGE))));
                contact.set_name(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME)));
                contact.set_last_name(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LAST_NAME)));
                userList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }


    // Getting Users Count
    public int getUsersCount() {
        String countQuery = "SELECT  * FROM " + DBHelper.TABLE_USERS;
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        db.close();

        return cursor.getCount();
    }

    // Updating single user
    public int updateUser(Users user) {
        SQLiteDatabase db = mHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.KEY_NAME, user.get_name());
        values.put(DBHelper.KEY_AGE, user.get_age());

        // updating row
        return db.update(DBHelper.TABLE_USERS, values, DBHelper.KEY_ID + " = ?",
                new String[] { String.valueOf(user.get_id()) });
    }


    // Deleting single contact
    public void deleteUser(Users contact) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_USERS, DBHelper.KEY_ID + " = ?",
                new String[] { String.valueOf(contact.get_id()) });
        db.close();
    }
}
