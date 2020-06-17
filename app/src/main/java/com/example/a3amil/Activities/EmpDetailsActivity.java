package com.example.a3amil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.a3amil.Model.EmployeeModel;
import com.example.a3amil.R;

import java.util.Random;

public class EmpDetailsActivity extends AppCompatActivity {
    private Bundle myBundle;
    private TextView empName;
    private TextView empAddress;
    private TextView empJob;
    private EmployeeModel employeeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_details);
//        myBundle = getIntent().getExtras();
////        employeeModel = (EmployeeModel) myBundle.getString("Name");
//        empName = findViewById(R.id.empNameDet);
//        empAddress = findViewById(R.id.empAddressDet);
//        empJob = findViewById(R.id.empJobDet);
//        empName.setText(myBundle.getString("Name"));
//        empJob.setText("نجار");
//        empAddress.setText("شمبات");
    }
}
