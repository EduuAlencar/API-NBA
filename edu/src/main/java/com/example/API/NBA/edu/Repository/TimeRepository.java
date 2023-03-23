package com.example.API.NBA.edu.Repository;

import com.example.API.NBA.edu.Models.TimeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends
        JpaRepository<TimeDAO, Long> {

}