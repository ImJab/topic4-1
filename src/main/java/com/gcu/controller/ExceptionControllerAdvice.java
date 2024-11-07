package com.gcu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        // Create a Model and View, populate with the Exception information, and display a common Error Page
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Error Page");
        model.addObject("errorMessage", "An Exception was not handled in the application: " + ex.getMessage());
        model.setViewName("exception");
        return model;
    }
}
