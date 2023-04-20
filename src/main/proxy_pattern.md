### Proxy pattern

Proxy : 대리인, 무언가를 대신 처리하는 것

개방폐쇄 원칙 (OCP)과 의존 역전 원칙 (DIP)를 따른다.

#### 적용
- Proxy class를 통해서 대신 전달하는 클래스를 만들고
- Client는 Proxy로부터 결과를 전달받는다.

ex) 캐시 기능

~~~
Client -> Interface subject (request()) -> Proxy (Request()) -> RealSubject(Request()) 
~~~