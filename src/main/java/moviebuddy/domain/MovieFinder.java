package moviebuddy.domain;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import moviebuddy.ApplicationException;
import moviebuddy.util.FileSystemUtils;

// MovieFinder 클래스의 관심사 분리를 위해 추상 클래스로 선언한다. 
public abstract class MovieFinder {
    /**
     * 저장된 영화 목록에서 감독으로 영화를 검색한다.
     * 
     * @param directedBy 감독
     * @return 검색된 영화 목록
     */
    public List<Movie> directedBy(String directedBy) {
        return loadMovies().stream()
                           .filter(it -> it.getDirector().toLowerCase().contains(directedBy.toLowerCase()))
                           .collect(Collectors.toList());
    }

    /**
     * 저장된 영화 목록에서 개봉년도로 영화를 검색한다.
     * 
     * @param releasedYearBy
     * @return 검색된 영화 목록
     */
    public List<Movie> releasedYearBy(int releasedYearBy) {
        return loadMovies().stream()
                           .filter(it -> Objects.equals(it.getReleaseYear(), releasedYearBy))
                           .collect(Collectors.toList());
    }

    // 추상 loadMovies 메서드
    public abstract List<Movie> loadMovies();
  
   
    
    // csv에서 불러오기 
    List<Movie> loadMoviesFromCSV(){
    	return Collections.emptyList();
    }
    
    // xml에서 불러오기 
    List<Movie> loadMoviesFromXML(){
    	return Collections.emptyList();
    }
    

}
