package moviebuddy.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class MovieFinder {
	
	// 인터페이스 인스턴스를 사용해 구현체를 참조하도록 한다.
    // MovieFinder 클래스 내부에서 메타데이터를 읽는 방식을 결정 (csv너, xml..)하기 때문에
    // 단지 객체를 new로 생성하는 행위지만 MovieFinder는 독립적으로 확장 가능한 클래스가 될 수 없다.
//	private MovieReader movieReader = new CsvMovieReader();
	
	// MovieFinder 내에서 메타 데이터를 읽는 방식을 결정하는게 아닌 외부에서 입력받도록 변경한다.
    private final MovieReader movieReader;

    // MovieFinder 객체는 외부에서 생성하고 생성자로 인스턴스 객체를 받아 읽는 역할(csv, xml...)을 구분한다.
    public MovieFinder(MovieReader movieReader){
        this.movieReader = Objects.requireNonNull(movieReader);
    }

    /**
     * 저장된 영화 목록에서 감독으로 영화를 검색한다.
     * 
     * @param directedBy 감독
     * @return 검색된 영화 목록
     */
    public List<Movie> directedBy(String directedBy) {
        return movieReader.loadMovies().stream()
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
        return movieReader.loadMovies().stream()
                           .filter(it -> Objects.equals(it.getReleaseYear(), releasedYearBy))
                           .collect(Collectors.toList());
    }  
   
    
}
