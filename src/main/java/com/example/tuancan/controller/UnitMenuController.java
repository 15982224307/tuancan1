package com.example.tuancan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/unitmenu")
public class UnitMenuController {

    @RequestMapping("/menu")
    public String menuAll(HttpServletRequest httpServletRequest, Model model){


        return "/groupmanager/unitmenu";
    }
}
