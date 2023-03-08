package com.example.todo.demo.todo.api.web;

import com.example.todo.demo.todo.api.web.model.SiteProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class TodoController {

    // 하드코딩되는 외부 값을 의존관계 주입으로 해결
//    private final Environment environment;
//    private final String siteAuthor;
    private final SiteProperties siteProperties;

    // environment 객체에 대한 외부 의존성을 해결하기 위해 생성자 파라미터로 .yml 외부 필드 값을 주입받는다.
    // 스프링 컨테이너가 bean을 확인하고 주입한다.
    public TodoController(SiteProperties siteProperties, Environment environment, @Value("${site.author}") String siteAuthor){
        this.siteProperties = siteProperties; // 모델 내 선언된 필드들을 빈 구성정보에 등록하고 모델 자체를 주입하는 방법

//        this.environment = environment; // yml 필드를 사용하기 위한 객체
//        this.siteAuthor = siteAuthor; // environment (외부 .yml)에서 주입하는 필드
    }

    // 주입된 모델 객체를 리턴
    // url 요청을 처리하는 핸들러 내부에서 모델, 뷰를 리턴하는 방법 대신 @ModelAttribute()를 사용할 수 있다.
    // model.addAttribute("site", siteProperties);
    @ModelAttribute("site")
    public SiteProperties siteProperties(){
        return siteProperties;
    }

    @RequestMapping("/todos") // 어노테이션의 요청 url로 뷰의 이름을 유추할 수 있다 (핸들러 내부에서 직접 뷰를 리턴하지 않아도됨)
    public void todos() throws Exception{
        // 1. 모델 객체에 대한 의존관계 주입 없이 environment만 의존성 주입하는 방법
//        SiteProperties site = new SiteProperties();
//        site.setAuthor(environment.getProperty("site.author")); // .yml 파일로부터 호출
//        siteProperties.setAuthor(environment.getProperty("site.author"));
//        site.setDescription(environment.getProperty("site.description"));

        // ModelAndView 객체로 모델과 뷰를 한꺼번에 리턴시키는 방법
//        ModelAndView mav = new ModelAndView();
        // modelAndView 객체에 모델을 바인딩한다. 모델 이름 : site
//        mav.addObject("site", site);

        // 2. 스프링 컨테이너로부터 siteProperties 모델을 주입받아 modelAndView에 바인딩하는 방법
//        mav.addObject("site", siteProperties);
//        mav.setViewName("todos");

        // ViewResolver로부터 반환받으려는 View 이름의 View 객체를 생성받는다. (해당 view가 없으면 Null)
        // viewname : "todos"
        // prefix : classpath:/templates/
        // suffix : .html
        // fullViewName : classpath:/templates/todos

//        ViewResolver viewResolver = new InternalResourceViewResolver();
//        View view = viewResolver.resolveViewName("todos", null);

//        model.addAttribute("site", siteProperties);
    }
}
