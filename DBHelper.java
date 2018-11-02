package com.androidexample.thecroutongame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wayne on 11/30/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "crouton.db";

    //constructor
    public DBHelper(Context activityContext){
        super(activityContext, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
            "CREATE TABLE users ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT, " +
                "crouton TEXT)"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
    }

    public void insertUser(String username, String password, String crouton){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("crouton", crouton);

        db.insert("users", null, contentValues);
    }

    public User getUserByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM users WHERE username = '" + username + "'", null);

        if(result.isAfterLast()) {
            return null;
        }

        result.moveToFirst();
        String name = result.getString(result.getColumnIndex("username"));
        String password = result.getString(result.getColumnIndex("password"));
        String crouton = result.getString(result.getColumnIndex("crouton"));
        int id = result.getInt(result.getColumnIndex("id"));

        return new User(name, password, crouton, id);
    }

} // END OF CLASS
