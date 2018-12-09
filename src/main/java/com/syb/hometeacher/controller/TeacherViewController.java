package com.syb.hometeacher.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.syb.hometeacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherViewController {
    @Inject
    TeacherService teacherService;

    @RequestMapping("showTeachers")
    @ResponseBody
    public String showTeachers(){
        return teacherService.getTeacherInfo();
    }

    @RequestMapping("helloworld")
    public ModelAndView toWelcome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello, Welcome to SpringMVC!");
        mv.setViewName("helloworld");
        return mv;
    }
}
