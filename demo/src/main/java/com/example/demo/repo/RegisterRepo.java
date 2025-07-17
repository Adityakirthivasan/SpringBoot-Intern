package com.example.demo.repo;

import com.example.demo.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface RegisterRepo extends JpaRepository<RegisterDetails, Integer> {
    Optional<RegisterDetails> findByUserName(String userName);
    List<RegisterDetails> findByNameContainingIgnoreCase(String keyword);
}
