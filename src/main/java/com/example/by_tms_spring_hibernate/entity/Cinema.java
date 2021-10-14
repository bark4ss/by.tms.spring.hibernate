package com.example.by_tms_spring_hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "cinemas")
public class Cinema extends BaseEntity {

    private String name;

    private String address;

    @OneToMany(mappedBy = "cinema",cascade = ALL, fetch = FetchType.EAGER)
    private Set<Film> films = new HashSet<>();

    public Cinema() {
    }

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addFilmsToCinema(Film film) {
        films.add(film);
        film.setCinema(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Film> getFilms() {
        return films;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
