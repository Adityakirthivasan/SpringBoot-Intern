//package com.example.demo.service;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyService {
//    public String getWelcomeMessage() {
//        return "Hello folks, welcome (from service)";
//    }
//    public String postMethod(){
//        return "This is a post method";
//    }
//    public String putMethod(){
//        return "This is a put method";
//    }
//    public String deleteMethod(){
//        return "This is a delete method";
//    }
//}

//✅ This is the final working code:



//Day 3
//package com.example.demo.service;
//
//import com.example.demo.models.Employee;
//// ✅ fixed import
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class MyService {
//
//    // Initialize the employee list
//    List<Employee> empList = new ArrayList<>(
//            Arrays.asList(
//                    new Employee(1, "Prasanth", "Trainer"),
//                    new Employee(2, "Yuvaraj", "Faculty")
//            )
//    );
//
//    // POST method
//    public String postMethod() {
//        return "Post method called successfully";
//    }
//
//    // GET method
//    public String getWelcomeMessage() {
//        return "Get method called successfully";
//    }
//
//    // PUT method
//    public String putMethod() {
//        return "Put method called";
//    }
//
//    // DELETE method
//    public String deleteMethod() {
//        return "Delete method called";
//    }
//
//    // Get all employees
//    public List<Employee> getAllEmployees() {
//        return empList;
//    }
//
//    // Add a new employee
//    public void addEmployee(Employee emp) {
//        empList.add(emp);
//    }
//}

//Day 6
//package com.example.demo.service;
//
//import com.example.demo.models.Employee;
//import com.example.demo.repo.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MyService {
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    // ✅ Welcome GET method
//    public String getWelcomeMessage() {
//        return "Get method called successfully";
//    }
//
//    // ✅ POST method
//    public String postMethod() {
//        return "Post method called successfully";
//    }
//
//    // ✅ PUT method
//    public String putMethod() {
//        return "Put method called";
//    }
//
//    // ✅ DELETE method
//    public String deleteMethod() {
//        return "Delete method called";
//    }
//
//    // ✅ Fetch all employees from DB
//    public List<Employee> getAllEmployees() {
//        return employeeRepo.findAll();
//    }
//
//    // ✅ Add employee to DB
//    public void addEmployee(Employee emp) {
//        employeeRepo.save(emp);
//    }
//}


//Day 6 Task
package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.models.Roles;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private RolesRepo rolesRepo;

    // ✅ GET: Welcome message
    public String getWelcomeMessage() {
        return "Get method called successfully";
    }

    // ✅ POST: Generic message
    public String postMethod() {
        return "Post method called successfully";
    }

    // ✅ PUT: Generic message
    public String putMethod() {
        return "Put method called";
    }

    // ✅ DELETE: Generic message
    public String deleteMethod() {
        return "Delete method called";
    }

    // ✅ Get all employees from DB
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    // ✅ Add employee with specified role name (like "USER" or "ADMIN")
    public void addEmployeeWithRole(Employee emp, String roleName) {
        Roles role = rolesRepo.findByRoleName(roleName);
        if (role != null) {
            emp.setRole(role);
            employeeRepo.save(emp);
        } else {
            throw new RuntimeException("Role not found: " + roleName);
        }
    }

    // ✅ Get only users with USER role
    public List<Employee> getAllUsersOnly() {
        Roles userRole = rolesRepo.findByRoleName("USER");
        return employeeRepo.findByRole(userRole);
    }

    // ✅ Get only admins
    public List<Employee> getAllAdminsOnly() {
        Roles adminRole = rolesRepo.findByRoleName("ADMIN");
        return employeeRepo.findByRole(adminRole);
    }
}

