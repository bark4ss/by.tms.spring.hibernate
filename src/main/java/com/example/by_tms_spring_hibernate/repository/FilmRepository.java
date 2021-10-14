package com.example.by_tms_spring_hibernate.repository;

import com.example.by_tms_spring_hibernate.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
