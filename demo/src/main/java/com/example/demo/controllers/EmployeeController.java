//package com.example.demo.controllers;
//
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/")
//    public String route(){
//        return "Welcome to SpringBoot Security";
//    }
//
//    @GetMapping("/employee")
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    public List<RegisterDetails> getMethod(){
//        return employeeService.getMethod();
//    }
//
//    @GetMapping("/employee/{empId}")
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    public RegisterDetails getEmployeeById(@PathVariable int empId){
//        System.out.println();
//        return employeeService.getEmployeeById(empId);
//    }
//
//    //    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    //    @GetMapping("/employee/job/{job}")
//    //    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job){
//    //        return employeeService.getEmployeeByJob(job);
//    //    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/employee")
//    public String postMethod(@RequestBody RegisterDetails employee){
//        //        Employee employee = new Employee(5,"Sivagami", "Business");
//        return employeeService.addEmployee(employee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employee/{empId}")
//    public String putMethod(@PathVariable int empId){
//        return employeeService.updateEmployee(empId);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/employee/{empID}")
//    public String deleteMethod(@PathVariable int empID){
//        return employeeService.deleteEmployeeById(empID);
//    }
//}
//package com.example.demo.controllers;
//
//import com.example.demo.models.RegisterDetails;
//import com.example.demo.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/")
//    public String route() {
//        return "Welcome to SpringBoot Security";
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee")
//    public List<RegisterDetails> getMethod() {
//        return employeeService.getMethod();
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
//    @GetMapping("/employee/{empId}")
//    public RegisterDetails getEmployeeById(@PathVariable int empId) {
//        return employeeService.getEmployeeById(empId);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/employee")
//    public String postMethod(@RequestBody RegisterDetails employee) {
//        return employeeService.addEmployee(employee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/employee/{empId}")
//    public String putMethod(@PathVariable int empId, @RequestBody RegisterDetails updatedEmployee) {
//        return employeeService.updateEmployee(empId, updatedEmployee);
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/employee/{empID}")
//    public String deleteMethod(@PathVariable int empID) {
//        return employeeService.deleteEmployeeById(empID);
//    }
//}
package com.example.demo.controllers;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Task;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<RegisterDetails> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public RegisterDetails getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public String addEmployee(@RequestBody RegisterDetails employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody RegisterDetails employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/{id}/tasks")
    public String assignTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.assignTask(id, task);
    }

    @GetMapping("/search")
    public List<RegisterDetails> searchEmployees(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    @GetMapping("/hello")
    public String route() {
        return "Welcome to SpringBoot Security";
    }
}
