package com.example.a3amil.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a3amil.databinding.ActivityEmployeeListBinding;
import com.example.a3amil.viewModel.EmployeeViewModel;
import com.example.a3amil.model.EmployeeModel;
import com.example.a3amil.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmpListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<EmployeeModel> employeeList;
    EmployeeViewModel viewModel;
    ActivityEmployeeListBinding employeeListBinding;
    String job;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeListBinding = DataBindingUtil.setContentView(this, R.layout.activity_employee_list);
        employeeListBinding.setLifecycleOwner(this);
        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        job = getIntent().getExtras().getString("job","سباك");
        employeeListBinding.name.setText(job);
        Objects.requireNonNull(getSupportActionBar()).hide();
        viewModel.getModels();
        initRecyclerView();
        viewModel.liveData.observe(this, new Observer<List<EmployeeModel>>() {
            @Override
            public void onChanged(List<EmployeeModel> empModels) {
                adapter.setEmployees((ArrayList<EmployeeModel>) empModels,job);
            }
        });

    }
    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this,job);
        recyclerView.setAdapter(adapter);
    }
}
