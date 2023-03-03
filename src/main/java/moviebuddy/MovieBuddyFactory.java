package moviebuddy;

import moviebuddy.domain.CsvMovieReader;
import moviebuddy.domain.MovieFinder;

// 객체를 생성하고 구성하는 역할을 하는 Factory 클래스
public class MovieBuddyFactory {
    public MovieFinder movieFinder(){
        return new MovieFinder(new CsvMovieReader());
    }
}
