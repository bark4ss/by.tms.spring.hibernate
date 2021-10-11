package com.example.by_tms_spring_hibernate.eception_handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ex", ex);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error/500");
        return modelAndView;
    }
}
