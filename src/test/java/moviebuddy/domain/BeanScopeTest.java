package moviebuddy.domain;

import moviebuddy.MovieBuddyFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Bean Scope 테스트
public class BeanScopeTest {

    // 빈 스코프 기본 싱글톤으로 하나의 객체만 생성되었는지 확인하는 테스트
    @Test
    void Equals_MovieFinderBean(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
        MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);
        // 하나의 컨테이너에서 생성된 빈 객체가 동일한지 (한개만 생성되었는지)
        Assertions.assertEquals(movieFinder, applicationContext.getBean(MovieFinder.class));
    }
}
