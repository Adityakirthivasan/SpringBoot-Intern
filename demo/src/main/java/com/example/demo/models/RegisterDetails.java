//package com.example.demo.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Set;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "user_details")
//public class RegisterDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int empId;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(name = "user_name", nullable = false, unique = true)
//    private String userName;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "empId"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
//    )
//    private Set<Roles> roles;
//}

package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
public class RegisterDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "empId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
    private Set<Roles> roles;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
    private Set<Task> tasks;
}
