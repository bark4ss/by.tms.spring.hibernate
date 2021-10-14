package com.example.by_tms_spring_hibernate.service;

import com.example.by_tms_spring_hibernate.repository.BaseDao;
import com.example.by_tms_spring_hibernate.entity.Cinema;
import com.example.by_tms_spring_hibernate.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cinemaService")
public class CinemaServiceImpl implements ServiceDao<Long, Cinema> {

    @Autowired
    /*@Qualifier("cinemaDaoBean")
    private BaseDao<Long,Cinema> baseDao;*/
    private CinemaRepository cinemaRepository;

    @Override
    //@Transactional
    public void save(Cinema cinema) {
        cinemaRepository.saveAndFlush(cinema);
    }

    @Override
    //@Transactional
    public void update(Cinema cinema) {
        cinemaRepository.saveAndFlush(cinema);
    }

    @Override
    //@Transactional
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }

    @Override
    //@Transactional
    public Cinema getById(Long id) {
        return cinemaRepository.findById(id).get();
    }

    @Override
    //@Transactional
    public List<Cinema> getAll() {
        return cinemaRepository.findAll();
    }
}

