package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {
    private Employee employee;
    private int numberofReports;

    public ReportingStructure(Employee employee, int numberofReports) {
        this.employee = employee;
        this.numberofReports = numberofReports;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public int getNumberofReports() {
        return this.numberofReports;
    }

    public void setNumberofReports(int numberofReports) {
        this.numberofReports = numberofReports;
    }
}
