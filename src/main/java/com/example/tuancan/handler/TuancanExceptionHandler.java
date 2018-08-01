package com.example.tuancan.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TuancanExceptionHandler {

     @ExceptionHandler(Exception.class)
     public ModelAndView  handleException(Exception e, HttpServletRequest request){

         return new ModelAndView("/manager/404");
    }
}
