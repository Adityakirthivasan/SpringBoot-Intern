//package com.example.demo.repo;
//
//import com.example.demo.models.Roles;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface RolesRepo extends JpaRepository<Roles, Integer> {
//    Roles findByRoleName(String role_Name);
//}
//Day 7
package com.example.demo.repo;

import com.example.demo.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {
    Roles findByRoleName(String roleName);
}
