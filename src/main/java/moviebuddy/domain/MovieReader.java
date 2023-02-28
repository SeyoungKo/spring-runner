package moviebuddy.domain;

import java.util.List;

// 코드 재사용을 위해 인터페이스를 사용함
public interface MovieReader {
	List<Movie> loadMovies();
}
