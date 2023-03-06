package moviebuddy.domain;

import moviebuddy.MovieBuddyFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author springrunner.kr@gmail.com
 */
public class MovieFinderTest {

//			1단계 : movieFinder로부터 바로 참조하는 객체 생성
//			MovieFinder movieFinder = new MovieFinder(new CsvMovieReader());

//			2단계 : 팩토리를 만들고 생성자에서 구현체 객체를 생성하도록 관심사 분리
//			MovieBuddyFactory movieBuddyFactory = new MovieBuddyFactory();
//			MovieFinder movieFinder = movieBuddyFactory.movieFinder();

//			3단계 :
			// applicationContext로 객체 생성 후 구현체는 어노테이션 객체를 활용한다.
			// (어노테이션 객체로부터 빈 구성정보를 읽고 applciationContext를 구성할 것)
			final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieBuddyFactory.class);
			// applicationContext는 beanFactory를 확장하고 있으므로 ac로부터 getBean()을 호출할 수 있다.
			final MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);


			@Test
			void NotEmpty_directedBy(){
				List<Movie> movies = movieFinder.directedBy("Michael Bay");
				Assertions.assertEquals(3, movies.size());
			}

}
