package com.example.lamalis.uncedo;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    DatabaseHelper mydp;
    ViewInfoActivity info;

    EditText edit_id, edit_name, edit_surname, edit_address, edit_hospital, edit_city, edit_municipality, edit_email, edit_telno;
    Button btnSubmit,btnPersonalInfo,btntestviewInfo;


    public void init(){


                AlertDialog.Builder a_builder = new AlertDialog.Builder(RegistrationActivity.this);
                a_builder.setMessage("Welcome: Your information have been saved, Do you want to EXIT now or LAUNCH COMPLAINT?")
                        .setCancelable(false)
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Launch Complaint", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent toy = new Intent(RegistrationActivity.this,LaunchCompActivity.class);
                        startActivity(toy);

                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Alert");
                alert.show();




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //calling the structure of a constructor
        mydp = new DatabaseHelper(this);

        //############################## We are CASTING widgets ##################################
        edit_id = (EditText)findViewById(R.id.txtPatID);
        edit_name = (EditText)findViewById(R.id.txtPatName);
        edit_surname = (EditText)findViewById(R.id.txtPatSurname);
        edit_address = (EditText)findViewById(R.id.txtPatAddress);
        edit_hospital = (EditText)findViewById(R.id.atxtHospital);
        edit_city = (EditText)findViewById(R.id.atxtCity);
        edit_municipality = (EditText)findViewById(R.id.atxtManicipality);
        edit_email = (EditText)findViewById(R.id.txtPatEmail);
        edit_telno = (EditText)findViewById(R.id.txtPatTel);
        btnSubmit = (Button)findViewById(R.id.btnRegistration);
        btnPersonalInfo =(Button)findViewById(R.id.btnPersonalInfo);
        btntestviewInfo = (Button)findViewById(R.id.btnTestviewInfo);

      // init();
       AddData();
       viewAll();
    }
    public void AddData(){

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     boolean isInserted = mydp.insertData(edit_id.getText().toString(),
                               edit_name.getText().toString(),
                               edit_surname.getText().toString(),
                               edit_address.getText().toString(),
                               edit_hospital.getText().toString(),
                               edit_city.getText().toString(),
                               edit_municipality.getText().toString(),
                               edit_email.getText().toString(),
                               edit_telno.getText().toString());
                     if(isInserted=true) {

                         Toast.makeText(RegistrationActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                         //init();


                     }else {
                         Toast.makeText(RegistrationActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
                     }
                    }
                }
        );

    }

    public void viewAll(){
        btntestviewInfo.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
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
                }
        );




    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
