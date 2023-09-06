package com.example.dbconnectioncreate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final  String DATABASE_NAME = "my_database.db";
    public static final int DATABASE_VERSION =1;

    //Table name and columns

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    private static final String TABLE_CREATE = " CREATE TABLE " + TABLE_NAME + " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+COLUMN_NAME+" TEXT, "+COLUMN_EMAIL+" TEXT)";

    public DBHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the tables in the database
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Upgrade the tables in the database
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
