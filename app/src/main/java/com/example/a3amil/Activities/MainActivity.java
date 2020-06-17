package com.example.a3amil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.a3amil.R;
import com.example.a3amil.ViewModel.EmployeeViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EmployeeViewModel viewModel;
    TextInputEditText empAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empAddress = findViewById(R.id.empAddressET);
        initSpinner();
    }
    private void initSpinner(){
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("سباك");
        spinnerArray.add("كهربائي");
        spinnerArray.add("نجار");
        spinnerArray.add("حداد");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

    }

    public void confirmBuOnClick(View view) {
        Intent empIntent = new Intent(this, EmpListActivity.class);
        startActivity(empIntent);
    }
}