package com.example.demo.repo;

import com.example.demo.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<RegisterDetails, Integer> {
    List<RegisterDetails> findByNameContainingIgnoreCase(String name);
}
