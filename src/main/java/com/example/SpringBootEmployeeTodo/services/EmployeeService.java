//Roles and id
// package com.example.SpringBootEmployeeTodo.services;
//
//import com.example.SpringBootEmployeeTodo.models.RegisterDetails;
//import com.example.SpringBootEmployeeTodo.repository.RegisterDetailsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    RegisterDetailsRepository registerDetailsRepository;
//
//    public List<RegisterDetails> getMethod() {
//        return registerDetailsRepository.findAll();
//    }
//
//    public RegisterDetails getEmployeeById(int empId) {
//        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
//    }
//
//    public String addEmployee(RegisterDetails employee) {
//        registerDetailsRepository.save(employee);
//        return "Employee Added Successfully";
//    }
//
//    public String updateEmployee(int empId, RegisterDetails updatedEmp) {
//        RegisterDetails user = registerDetailsRepository.findById(empId).orElse(null);
//        if (user != null) {
//            user.setName(updatedEmp.getName());
//            user.setEmail(updatedEmp.getEmail());
//            user.setPassword(updatedEmp.getPassword());
//            registerDetailsRepository.save(user);
//            return "Employee Updated Successfully";
//        }
//        return "Employee Not Found";
//    }
//
//    public String deleteEmployeeById(int empId) {
//        registerDetailsRepository.deleteById(empId);
//        return "Employee Deleted Successfully";
//    }
//}
//Todo
//package com.example.demo.services;
//
//import com.example.demo.models.Employee;
//import com.example.demo.repo.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public String addEmployee(Employee emp) {
//        employeeRepository.save(emp);
//        return "Employee added successfully";
//    }
//
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    public Employee getEmployeeById(Long empid) {
//        return employeeRepository.findById(empid).orElse(null);
//    }
//
//    public String updateEmployee(Long empid, Employee updated) {
//        Employee existing = employeeRepository.findById(empid).orElse(null);
//        if (existing != null) {
//            existing.setName(updated.getName());
//            existing.setEmail(updated.getEmail());
//            existing.setPassword(updated.getPassword());
//            employeeRepository.save(existing);
//            return "Employee updated successfully";
//        }
//        return "Employee not found";
//    }
//
//    public List<Employee> getEmployeesByRole(String role) {
//        return employeeRepository.findByRole(role);
//    }
//}
