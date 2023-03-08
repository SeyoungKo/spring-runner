### 스프링 MVC의 요청/응답 처리 흐름
- 프론트 컨트롤러인 DispatcherServlet 중심으로 동작한다.
 - DispatcherServlet : 스프링 MVC에서 제공하는 자바 서블릿으로 모든 요청에 대해 연결된 컨트롤러에게 요청 위임, 뷰 선택, 결과 출력 등을 처리해준다.
   (컨트롤러로부터 모델, 뷰를 반환받아서 응답 처리)
 - ViewResolver : 뷰 객체를 생성. 디스패처 서블릿이 뷰 이름을 가지고 해당 뷰를 찾아달라고 요청하면 뷰 객체를 리턴한다.


### 스프링 컨테이너 의존관계 주입
- 외부 의존성을 해결하기 위해 사용한다.
~~~
1. 생성자 파라미터 활용
2. setter 메서드 활용
~~~
=> 스프링 컨테이너는 의존관계가 발생한 클래스 객체를 생성할 때 1 혹은 2에서 주입된 bean 객체가 Configuration에 등록되어 있는지
확인하고, bean 객체를 주입한다.

### @Configuration 메타데이터에 선언된 bean 객체 전체 등록하기
- @ConfigurationPropertiesScan : 해당 패키지 하위에 등록된 전체 bean을 탐색하고 스프링 컨테이너에 bean으로 자동 등록한다.

```
// bean 등록하는 다음 코드를 생략함

@Bean
public SiteProperties siteProperties() {
   return new SiteProperties();
}
```
