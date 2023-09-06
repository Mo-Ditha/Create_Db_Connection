package com.example.dbconnectioncreate;

import static com.example.dbconnectioncreate.R.id.textview1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview1);
        dbManager = new DBManager(this);
        dbManager.open();

        long userId = dbManager.insertUser("Moditha", "moditha@gmail.com");

        Cursor cursor =dbManager.getAllUsers();

        dbManager.close();
    }
}
