package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return getNumberOfReports(employee);
    }

    private ReportingStructure getNumberOfReports(Employee employee){
        //Perform iterative BFS to get all direct reports underneath the employee passed in
        List<Employee> employeeQueue = new ArrayList<>();
        employeeQueue.add(employee);
        int numReports = 0;
        while(!employeeQueue.isEmpty()){
            Employee current = employeeQueue.remove(0);
            if(current.getDirectReports() != null){
                for(Employee e : current.getDirectReports()){
                    numReports++;
                    Employee tempEmployee = employeeRepository.findByEmployeeId(e.getEmployeeId());
                    LOG.debug("adding employee [{}]", tempEmployee.getFirstName() + tempEmployee.getLastName());
                    employeeQueue.add(tempEmployee);
                }
            }
        }
        LOG.debug("Num reporting [{}]", numReports);
        return new ReportingStructure(employee, numReports);
    }
}
