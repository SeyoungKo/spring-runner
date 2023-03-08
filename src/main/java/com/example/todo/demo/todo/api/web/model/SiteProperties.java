package com.example.todo.demo.todo.api.web.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 빈 객체 정보를 구성할 때 외부로부터 참조하겠다는 어노테이션
// prefix에 정의된 도메인의 필드를 키 값으로 접근할 수 있다.
@ConfigurationProperties(prefix="site")
public class SiteProperties {

    private String author = "unknown";
    private String description = "TodoApp for Server-side";

    public SiteProperties(){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
