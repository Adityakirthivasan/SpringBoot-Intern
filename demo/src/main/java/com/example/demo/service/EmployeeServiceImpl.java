package com.example.demo.service;

import com.example.demo.models.RegisterDetails;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public List<RegisterDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public RegisterDetails getEmployeeById(int empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    @Override
    public String addEmployee(RegisterDetails employee) {
        employeeRepository.save(employee);
        return "Employee Added Successfully";
    }

    @Override
    public String updateEmployee(int empId, RegisterDetails updatedEmployee) {
        RegisterDetails existing = employeeRepository.findById(empId).orElse(null);
        if (existing == null) return "Employee Not Found";
        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setUserName(updatedEmployee.getUserName());
        employeeRepository.save(existing);
        return "Employee Updated Successfully";
    }

    @Override
    public String deleteEmployeeById(int empId) {
        if (!employeeRepository.existsById(empId)) {
            return "Employee Not Found";
        }
        employeeRepository.deleteById(empId);
        return "Deleted Successfully";
    }

    @Override
    public List<RegisterDetails> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
}
