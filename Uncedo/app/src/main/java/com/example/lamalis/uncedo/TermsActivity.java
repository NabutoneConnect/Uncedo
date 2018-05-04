package com.example.lamalis.uncedo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TermsActivity extends AppCompatActivity {

    public Button btnContinue, btnExit;


    public void agrement(){
        btnContinue = (Button) findViewById(R.id.btnRegistration);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermsActivity.this,RegistrationActivity.class);
                    startActivity(intent);

            }
        });


    } public void notagreeing(){
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        agrement();
        notagreeing();
    }
}
