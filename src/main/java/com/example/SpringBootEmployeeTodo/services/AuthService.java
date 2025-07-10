package com.example.SpringBootEmployeeTodo.services;

import com.example.SpringBootEmployeeTodo.models.RegisterDetails;
import com.example.SpringBootEmployeeTodo.models.Roles;
import com.example.SpringBootEmployeeTodo.models.UserDetailsDto;
import com.example.SpringBootEmployeeTodo.repository.RegisterDetailsRepository;
import com.example.SpringBootEmployeeTodo.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());

        List<Roles> allRoles = rolesRepository.findAll();
        Set<Roles> userRoles = registerDetails.getRoles();

        for (String roleName : register.getRoleNames()) {
            for (Roles role : allRoles) {
                if (role.getRoleName().equals(roleName)) {
                    userRoles.add(role);
                    break;
                }
            }
        }

        registerDetails.setRoles(userRoles);
        registerDetailsRepository.save(registerDetails);
        return "Employee Added Successfully";
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = registerDetailsRepository.findByEmail(login.getEmail());
        if (user != null) {
            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                return "Login Successful";
            }
        }
        return "Login Not Successful";
    }
}
