package com.example.by_tms_spring_hibernate.service;

import com.example.by_tms_spring_hibernate.repository.BaseDao;
import com.example.by_tms_spring_hibernate.entity.Film;
import com.example.by_tms_spring_hibernate.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("filmService")
public class FilmServiceImpl implements ServiceDao<Long, Film> {

    @Autowired
    /*@Qualifier("filmDaoBean")
    private BaseDao<Long, Film> baseDao;*/
    private FilmRepository filmRepository;

    @Override
    //@Transactional
    public void save(Film film) {
        filmRepository.saveAndFlush(film);
    }

    @Override
    //@Transactional
    public void update(Film film) {
        filmRepository.saveAndFlush(film);
    }

    @Override
    //@Transactional
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    //@Transactional
    public Film getById(Long id) {
        return filmRepository.findById(id).get();
    }

    @Override
    //@Transactional
    public List<Film> getAll() {
        return filmRepository.findAll();
    }
}
