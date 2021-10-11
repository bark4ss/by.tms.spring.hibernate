package com.example.by_tms_spring_hibernate.controller;

import com.example.by_tms_spring_hibernate.entity.Cinema;
import com.example.by_tms_spring_hibernate.entity.Film;
import com.example.by_tms_spring_hibernate.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class CinemaController {

    @Autowired
    @Qualifier("cinemaService")
    private ServiceDao<Long, Cinema> cinemaServiceDao;


    @GetMapping()
    public ModelAndView AllCinemas(ModelAndView model) {

        List<Cinema> cinemas = cinemaServiceDao.getAll();
        model.addObject("allCinemas", cinemas);
        model.setViewName("all-cinemas");

        return model;
    }

    @GetMapping("/exception/{type}")
    public String errorHandling(@PathVariable("type") String type, ModelAndView modelAndView) throws Exception {
        if("sql".equals(type)) {
            throw new SQLException("sql");
        }
        if("exc".equals(type)) {
            throw new Exception("excep");
        }
        return "all-cinemas";
    }

    @GetMapping("/cinema/{id}")
    public ModelAndView film(@PathVariable("id") long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinema");
        Cinema cinema = cinemaServiceDao.getById(id);
        modelAndView.addObject(cinema);

        return modelAndView;
    }

    @PostMapping("/cinema/add")
    public ModelAndView addCinema(@ModelAttribute("cinema") Cinema cinema, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Hello Message");
        ModelAndView modelAndView = new ModelAndView();
        cinemaServiceDao.save(cinema);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        Cinema cinema = new Cinema();
        Film film = new Film();
        model.addAttribute("film", film);
        model.addAttribute("cinema", cinema);
    }

    @ExceptionHandler(SQLException.class)
    public ModelAndView handleError(HttpServletRequest req, SQLException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ex", ex);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error/500");
        return modelAndView;
    }
}
