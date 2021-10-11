package com.example.by_tms_spring_hibernate.repository;

import com.example.by_tms_spring_hibernate.entity.Cinema;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cinemaDaoBean")
public class CinemaDaoImpl implements BaseDao<Long, Cinema> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Cinema cinema) {
        Session session = sessionFactory.openSession();
        session.save(cinema);
    }

    @Override
    public void update(Cinema cinema) {
        Session session = sessionFactory.openSession();
        session.update(cinema);
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Query<Cinema> query = session.createQuery("delete from Cinema where id=:cinemaId");
        query.setParameter("cinemaId",id);
        query.executeUpdate();
    }

    @Override
    public Cinema getById(Long id) {
        Session session = sessionFactory.openSession();
        Cinema cinema = session.get(Cinema.class, id);
        return cinema;
    }

    @Override
    public List<Cinema> getAll() {
        Session session = sessionFactory.openSession();
        Query<Cinema> query = session.createQuery("select c from Cinema c", Cinema.class);
        List<Cinema> allCinemas = query.getResultList();
        return allCinemas;
    }
}
