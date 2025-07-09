//Day 6
//package com.example.demo.security;
//
//import com.example.demo.models.Employee;
//import com.example.demo.repo.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Employee emp = employeeRepo.findByEmail(email);
//        if (emp == null) {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
//
//        // Make sure emp.getRole() returns values like "USER" or "ADMIN"
//        return new org.springframework.security.core.userdetails.User(
//                emp.getEmail(),
//                emp.getPassword(),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + emp.getRole()))
//        );
//    }
//}

//Day 6 Task
package com.example.demo.security;

import com.example.demo.models.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee emp = employeeRepo.findByEmail(email);
        if (emp == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                emp.getEmail(),
                emp.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + emp.getRole().getRole_Name()))
        );
    }
}
