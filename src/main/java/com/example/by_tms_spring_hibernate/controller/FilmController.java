package com.example.by_tms_spring_hibernate.controller;

import com.example.by_tms_spring_hibernate.entity.Cinema;
import com.example.by_tms_spring_hibernate.entity.Film;
import com.example.by_tms_spring_hibernate.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    @Qualifier("cinemaService")
    private ServiceDao<Long, Cinema> cinemaServiceDao;

    @Autowired
    @Qualifier("filmService")
    private ServiceDao<Long, Film> filmServiceDao;

    @PostMapping("/add")
    public ModelAndView addFilm(@ModelAttribute("film") Film film){
        filmServiceDao.save(film);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cinema/"+film.getCinema().getId());

        return modelAndView;
    }

    @GetMapping("/forward")
    public ModelAndView filmForward(ModelAndView modelAndView) {
        modelAndView.setViewName("forward:/cinema/1");
        return modelAndView;
    }

    @GetMapping("/forward2")
    public ModelAndView filmForward2(ModelAndView modelAndView) {
        modelAndView.setViewName("/cinema/1");
        return modelAndView;
    }

    @GetMapping("/redirect")
    public String filmRedirect(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg","hello flash");
        return "redirect:/film/destination";
    }

    @GetMapping("/destination")
    public String filmDestination() {
        return "destination";
    }

}
