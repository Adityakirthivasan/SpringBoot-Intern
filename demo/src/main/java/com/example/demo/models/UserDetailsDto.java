package com.example.demo.models;

import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    private int empId;
    private String name;
    private String email;
    private String password;
    private String userName;
    private Set<String> roleNames;
}
