package moviebuddy;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// 객체를 생성하고 구성하는 역할을 하는 Factory 클래스
// 스프링의 bean 객체를 사용하고 어떤 bean이 구성되어 있는지 configuration를 붙임
// 컨테이너는 자바로 작성된 빈 구성정보를 읽어서 어떻게 bean을 생성할지 스스로 판단할 수 있다. ex - 메서드 생성, 파라미터 생성 등
@Configuration
public class MovieBuddyFactory {

    @Bean
    public MovieReader movieReader(){
        return new CsvMovieReader();
    }

    // 다른 bean 객체를 생성하는 메서드를 호출해서 의존관계를 주입하는 방법
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 프로토타입 스코프
    public MovieFinder movieFinder(){
        return new MovieFinder(movieReader());
    }

    // 파라미터로 다른 의존관계를 받아오는 방법
//    @Bean
//    public MovieFinder movieFinder(MovieReader movieReader){
//        return new MovieFinder(movieReader);
//    }

//    @Bean
//    public MovieFinder movieFinder(){
//        return new MovieFinder(new CsvMovieReader());
//    }
}
