////Day 6 Task
//package com.example.demo.models;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "roles")
//public class Roles {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int roleID;
//
//    private String roleName;
//
//    public int getRoleID() {
//        return roleID;
//    }
//
//    public void setRoleID(int roleID) {
//        this.roleID = roleID;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
//}

//Day 7
//Day10
package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    private String roleName;

    // Getters and setters
    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
