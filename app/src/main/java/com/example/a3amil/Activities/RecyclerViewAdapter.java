package com.example.a3amil.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3amil.databinding.EmployeeRowBinding;
import com.example.a3amil.model.EmployeeModel;
import com.example.a3amil.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private  String job;
    private View view;
    private CardView cardView;
    private RecyclerView.ViewHolder holder;
    private ArrayList<EmployeeModel> employees = new ArrayList<>();
    private Context context;
    private EmployeeModel emp;

    public RecyclerViewAdapter(Context context,String job) {
        this.context = context;
        this.job = job;
    }

    public void setEmployees(ArrayList<EmployeeModel> employees, String job) {
        for (EmployeeModel emp:employees) {
            if(emp.getEmpJob().equals(job))
                this.employees.add(emp);
        }
//        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EmployeeRowBinding rowBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),R.layout.employee_row,parent,false);
//        cardView = view.findViewById(R.id.cardView);
        return new RecyclerViewAdapter.ViewHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        emp = employees.get(position);
        holder.rowBinding.setEmployee(emp);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView empName,empNum;
        EmployeeModel employee;
        EmployeeRowBinding rowBinding;

        public ViewHolder(@NonNull EmployeeRowBinding itemView) {
            super(itemView.getRoot());
//            itemView.setOnClickListener(this);
//            empName = itemView.findViewById(R.id.empName);
//            empNum = itemView.findViewById(R.id.empNumber);
            rowBinding = itemView;
        }

        @Override
        public void onClick(View v) {
//            Intent detailsIntent = new Intent(context, EmpDetailsActivity.class);
//            detailsIntent.putExtra("ID", String.valueOf(emp));
//            context.startActivity(detailsIntent);
        }
    }
}
