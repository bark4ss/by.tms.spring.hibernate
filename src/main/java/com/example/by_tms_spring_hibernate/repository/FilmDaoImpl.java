package com.example.by_tms_spring_hibernate.repository;

import com.example.by_tms_spring_hibernate.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("filmDaoBean")
public class FilmDaoImpl {
    //implements BaseDao<Long, Film>
    /*@Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Film film) {
        Session session = sessionFactory.openSession();
        session.save(film);
    }

    @Override
    public void update(Film film) {
        Session session = sessionFactory.openSession();
        session.update(film);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Query<Film> query = session.createQuery("delete from Film where id=:filmId");
        query.setParameter("filmId",id);
        query.executeUpdate();
    }

    @Override
    public Film getById(Long id) {
        Session session = sessionFactory.openSession();
        Film film = session.get(Film.class, id);
        return film;
    }

    @Override
    public List<Film> getAll() {
        Session session = sessionFactory.openSession();
        Query<Film> query = session.createQuery("select f from Film f", Film.class);
        List<Film> allFilms = query.getResultList();
        return allFilms;
    }*/
}
