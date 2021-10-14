package com.example.by_tms_spring_hibernate.repository;

import com.example.by_tms_spring_hibernate.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
