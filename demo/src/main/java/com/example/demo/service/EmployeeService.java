//Day 10
package com.example.demo.service;
import com.example.demo.models.Employee;

import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getMethod() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElse(new Employee());
    }

    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee Added Successfully";
    }

    public String updateEmployee(int empId) {
        Employee user = employeeRepo.findById(empId)
                .orElseThrow(() -> new RuntimeException("No Such User Present"));
        employeeRepo.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empId) {
        employeeRepo.deleteById(empId);
        return "Employee Deleted Successfully";
    }
}
