package com.example.by_tms_spring_hibernate.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "films")
public class Film extends BaseEntity {

    private String name;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime time;

    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name="cinema_id")
    private Cinema cinema;

    public Film() {
    }

    public Film(String name, String description, LocalDate date, LocalTime time, BigDecimal cost) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", cost=" + cost +
                '}';
    }
}
