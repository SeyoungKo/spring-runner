//package moviebuddy.domain;
//
//import moviebuddy.ApplicationException;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.net.URL;
//import java.util.List;
//
//public class JaxbMovieReader implements MovieReader{
//    @Override
//    public List<Movie> loadMovies() {
//        // jaxb context 객체 생성
//        try{
//            final JAXBContext jaxb = JAXBContext.newInstance(MovieMetadata.class);
//            final Unmarshaller unmarshaller = jaxb.createUnmarshaller();
//
//            // unmarshal
//            final MovieMetadata metadata = unmarshaller.unmarshal(source);
//
//        }catch (JAXBException error){
//            throw new ApplicationException("failed to load movie data", error);
//        }
//        return null;
//    }
//
//    @XmlRootElement(name = "moviemetadata")
//    public static class MovieMetadata {
//        private List<MovieData> movies;
//
//    }
//
//    public static class MovieData{
//        private String title;
//        private List<String> genre;
//        private String language;
//        private String country;
//        private int releaseYear;
//        private String director;
//        private List<String> actors;
//        private URL imdbLink;
//        private String watchedData;
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public List<String> getGenre() {
//            return genre;
//        }
//
//        public void setGenre(List<String> genre) {
//            this.genre = genre;
//        }
//
//        public String getLanguage() {
//            return language;
//        }
//
//        public void setLanguage(String language) {
//            this.language = language;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//        public int getReleaseYear() {
//            return releaseYear;
//        }
//
//        public void setReleaseYear(int releaseYear) {
//            this.releaseYear = releaseYear;
//        }
//
//        public String getDirector() {
//            return director;
//        }
//
//        public void setDirector(String director) {
//            this.director = director;
//        }
//
//        public List<String> getActors() {
//            return actors;
//        }
//
//        public void setActors(List<String> actors) {
//            this.actors = actors;
//        }
//
//        public URL getImdbLink() {
//            return imdbLink;
//        }
//
//        public void setImdbLink(URL imdbLink) {
//            this.imdbLink = imdbLink;
//        }
//
//        public String getWatchedData() {
//            return watchedData;
//        }
//
//        public void setWatchedData(String watchedData) {
//            this.watchedData = watchedData;
//        }
//    }
//}
