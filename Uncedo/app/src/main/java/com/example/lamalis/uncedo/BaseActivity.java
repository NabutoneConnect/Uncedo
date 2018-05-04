package com.example.lamalis.uncedo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    DatabaseHelper mydp;
    RegistrationActivity info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        viewAll();
    }


    // this is the option menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.commonmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.mnuUpdate)
        {
            Toast.makeText(this,"Update menu is Clicked",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, UpdateInfoActivity.class));
    }
        else

        if(id==R.id.mnuView)
        {

            Toast.makeText(this,"View personal information menu is Clicked",Toast.LENGTH_SHORT).show();

            //info.viewAll();
            startActivity(new Intent(this, ViewInfoActivity.class));



        }
        else

        if(id==R.id.mnuLaunchCom)
        {
            Toast.makeText(this,"Complaint menu is Clicked",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LaunchCompActivity.class));
        }
        else
        if(id==R.id.mnuViewCompl)
        {
            Toast.makeText(this,"View Complaints menu is Clicked",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ViewCompActivity.class));
        }
        else

            startActivity(new Intent(this, RegistrationActivity.class));

        return super.onOptionsItemSelected(item);
    }



    public void viewAll(){

                        Cursor res = mydp.getAllData();
                        if(res.getCount() == 0){
                            // show message
                            showMessage("Error","No data found!");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id Number :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Surname :"+ res.getString(2)+"\n");
                            buffer.append("Address :"+ res.getString(3)+"\n");
                            buffer.append("Hospital/Clinic Name :"+ res.getString(4)+"\n");
                            buffer.append("City/Town Name :"+ res.getString(5)+"\n");
                            buffer.append("Municipality name :"+ res.getString(6)+"\n");
                            buffer.append("E-mail:"+ res.getString(7)+"\n");
                            buffer.append("Tel Number:"+ res.getString(8)+"\n\n\n");

                        }
                        // show all data
                        showMessage("Personal Information",buffer.toString());

                    }


    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }




}
