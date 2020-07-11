package com.example.a3amil.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a3amil.ViewModel.EmployeeViewModel;
import com.example.a3amil.Model.EmployeeModel;
import com.example.a3amil.R;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<EmployeeModel> employeeList;
    EmployeeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        initRecyclerView();
        adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        viewModel.getToken();
        viewModel.getModels();
        viewModel.liveData.observe(this, new Observer<List<EmployeeModel>>() {
            @Override
            public void onChanged(List<EmployeeModel> empModels) {
                adapter.setEmployees((ArrayList<EmployeeModel>) empModels);
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
