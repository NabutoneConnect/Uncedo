package com.example.lamalis.uncedo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LaunchCompActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_comp);

        Spinner illnessCategorySpinner =  (Spinner) findViewById(R.id.sprIllnessCategory);
        Spinner problemCategotySpinner = (Spinner) findViewById(R.id.sprProblemCategory);

        // an array adapter holds the values
        ArrayAdapter<String> illnessAdpter = new ArrayAdapter<String>(LaunchCompActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.IllnessCategory));
        //then you need to spacify that this adapter will have a dropdown list
        illnessAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Now to show the data inside the spinner
        illnessCategorySpinner.setAdapter(illnessAdpter);

        // an array adapter holds the values
        ArrayAdapter<String> problemAdapter = new ArrayAdapter<String>(LaunchCompActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.ProblemCategory));
        //then you need to spacify that this adapter will have a dropdown list
       problemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Now to show the data inside the spinner
       problemCategotySpinner.setAdapter(problemAdapter);


    }
}
