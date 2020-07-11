package com.example.a3amil.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3amil.Model.EmployeeModel;
import com.example.a3amil.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private View view;
    private CardView cardView;
    private RecyclerView.ViewHolder holder;
    private ArrayList<EmployeeModel> employees = new ArrayList<>();
    private Context context;
    private EmployeeModel emp;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setEmployees(ArrayList<EmployeeModel> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_row,parent,false);
        cardView = view.findViewById(R.id.cardView);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        emp = employees.get(position);
        holder.empName.setText(emp.getEmpName());
        holder.empNum.setText((emp.getEmpNum()));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView empName,empNum;
        EmployeeModel employee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            empName = itemView.findViewById(R.id.empName);
            empNum = itemView.findViewById(R.id.empNumber);
        }

        @Override
        public void onClick(View v) {
//            Intent detailsIntent = new Intent(context, EmpDetailsActivity.class);
//            detailsIntent.putExtra("ID", String.valueOf(emp));
//            context.startActivity(detailsIntent);
        }
    }
}
