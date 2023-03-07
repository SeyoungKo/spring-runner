package com.example.todo.demo.todo.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class TodoController {

    @RequestMapping("/todos")
    public ModelAndView todos() throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.setViewName("todos");

        // ViewResolver로부터 반환받으려는 View 이름의 View 객체를 생성받는다. (해당 view가 없으면 Null)
        // viewname : "todos"
        // prefix : classpath:/templates/
        // suffix : .html
        // fullViewName : classpath:/templates/todos

        ViewResolver viewResolver = new InternalResourceViewResolver();
        View view = viewResolver.resolveViewName("todos", null);

        return mav;
    }
}
