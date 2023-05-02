### Facade pattern

Facade : 건물의 앞쪽 정면

여러개의 객체와 실제 사용하는 서브 객체 사이에 복잡한 의존관계가 있을 때, 중간에 facade 객체를 두고 
facade 객체에서 제공하는 인터페이스만을 활용해 기능을 사용하는 방식 

facade는 자신이 가지고 있는 각 클래스의 기능을 명확히 알아야 한다.

```
ex) Client -> facade (중간 객체) -> Writer, Reader ...
 - 이 예시에서는 facade가 writer, reader 등의 클래스를 가지고 있어 connect()라는 메서드 한개만 호출해도 나머지 서브 객체들을 호출할 수 있다.
```


