package com.mindex.challenge.data;

import java.util.Date;
public class Compensation {
    private String employeeId;
    private double salary;
    private Date effectiveDate;

    public Compensation() {
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() { return this.salary; }

    public void setSalary(double salary) { this.salary = salary; }

    public Date getEffectiveDate() { return this.effectiveDate; }

    public void setEffectiveDate(Date effectiveDate) { this.effectiveDate = effectiveDate; }
}
