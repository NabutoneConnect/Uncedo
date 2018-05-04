package com.example.lamalis.uncedo;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class ViewInfoActivity extends BaseActivity {

    DatabaseHelper mydp;
    MenuItem mnuView;
    Button btnPersonalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);
        btnPersonalInfo = (Button)findViewById(R.id.btnPersonalInfo);


        mnuView = (MenuItem)findViewById(R.id.mnuView);

       // viewAll();
    }



}
