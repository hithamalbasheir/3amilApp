package com.example.a3amil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.a3amil.R;
import com.example.a3amil.viewModel.EmployeeViewModel;
import com.example.a3amil.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    EmployeeViewModel viewModel;
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        mainBinding.setViewmodel(viewModel);
        mainBinding.setLifecycleOwner(this);
        viewModel.getModels();
        initSpinner();
    }

    private void initSpinner(){
//        employeeModels = viewModel.liveData.getValue();
//        Set<String> jobs = new HashSet<>();
//        try {
//            for(EmployeeModel model:employeeModels
//            ) {
//                jobs.add(model.getEmpJob());}
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("سباك");
        spinnerArray.add("كهربائي");
        spinnerArray.add("نجار");
        spinnerArray.add("حداد");
        spinnerArray.add("نقاش");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainBinding.spinner.setAdapter(adapter);

    }

    public void confirmBuOnClick(View view) {
        Intent empIntent = new Intent(this, EmpListActivity.class);
        empIntent.putExtra("job", mainBinding.spinner.getSelectedItem().toString());
        startActivity(empIntent);
    }

    boolean doubleBackToExitPressedOnce = false;
    // to confirm quitting the app
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.onBackPressed, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2690);
    }

}