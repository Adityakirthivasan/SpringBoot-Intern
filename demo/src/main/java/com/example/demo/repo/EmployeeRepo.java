//Day 6
package com.example.demo.repo;

import com.example.demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    //  Find employee by email - useful for login/authentication
    Employee findByEmail(String email);
}


