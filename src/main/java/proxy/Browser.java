package proxy;

public class Browser implements IBrowser{
    private String url;

    public Browser(String url){
        this.url = url;
    }

    // 인터페이스 show()를 구현하여 html 클래스에 url을 담아 리턴시킨다.
    @Override
    public Html show() {
        System.out.println("browser loading html from: "+ url);
        return new Html(url);
    }
}
