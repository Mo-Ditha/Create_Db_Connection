package com.example.dbconnectioncreate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context c){
        context =c;
    }
    public DBManager open() throws SQLException{

        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void  close() {
        dbHelper.close();
    }

    public long insertUser(String name,String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_NAME,name);
        contentValues.put(DBHelper.COLUMN_EMAIL,email);
        return  database.insert(DBHelper.TABLE_NAME, null,contentValues);
    }

    public Cursor getAllUsers(){
        String[] columns = {DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME, DBHelper.COLUMN_EMAIL};
        return database.query(DBHelper.TABLE_NAME, columns, null,null,null,null,null);
    }


}
