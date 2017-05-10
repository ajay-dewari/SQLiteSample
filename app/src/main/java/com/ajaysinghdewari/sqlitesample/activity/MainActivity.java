package com.ajaysinghdewari.sqlitesample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ajaysinghdewari.sqlitesample.R;
import com.ajaysinghdewari.sqlitesample.db.MyDB;
import com.ajaysinghdewari.sqlitesample.models.Users;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
