package com.example.a3amil.Model;

public class EmployeeModel {
    private String empName;
    private String empAddress;
    private String empJob;
    private String empNum;

    // TODO: 6/17/20  
    public EmployeeModel(String empName, String empAddress, String empJob, String empNum) {
        this.empName = empName;
        this.empAddress = empAddress;
        this.empJob = empJob;
        this.empNum = empNum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }
}
