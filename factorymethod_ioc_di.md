## 객체를 느슨하게 결합하기

### 오브젝트 팩토리로 객체 생성, 사용에 대한 역할과 책임 분리하기

- factory : 객체의 생성 방법을 결정하고 생성한 객체를 반환. 객체 생성과 사용 역할을 분리하려는 목적으로 사용한다.

### 제어의 역전 (Inversion of Control IOC)

- IOC : 프로그램의 제어 흐름 구조가 뒤바뀌는 것. 객체가 자신이 사용할 객체를 스스로 결정하거나 생성하지 않는다. 제어 권한을 다른 대상에게 위임
  (일반적으로 모든 객체는 능동적으로 자신이 사용할 객체를 결정하고 언제, 어떻게 만들지 스스로 관장함. 즉, 모든 종류의 흐름을 사용하는 쪽에서 제어하는 구조)

  - 팩토리 도입 전 흐름
   <img width="600" alt="스크린샷 2023-03-03 오후 3 21 56" src="https://user-images.githubusercontent.com/39934875/223005478-6613b96a-95ce-4e6b-93af-c86a34649586.png">

  - 팩토리 도입 이후 뒤바뀐 제어 흐름
   <img width="600" alt="스크린샷 2023-03-03 오후 3 22 52" src="https://user-images.githubusercontent.com/39934875/223005534-7e7c8617-b21e-4406-bb9c-2fd192a98746.png">

- 장점

```
- 설계가 깨끗해지고 유연성이 증가하며 확장성이 좋아진다.
- 특정 기술이나 환경에 종속되지 않는 보편적으로 사용하는 패턴이다.
```

### 소프트웨어 설계 원칙과 디자인 패턴

- SOLID 원칙 : 깔끔한 설계를 위해 적용 가능한 다섯가지 소프트웨어 설계 원칙

```
- Single responsibility
- Open / Closed
- Liskov substitution
- Interface segregation
- Dependency inversion principle
```

### 의존관계와 의존관계 주입 (Dependency Injection DI)

제어의 역전보다 명확한 개념

- DI : 의존 관계에 있는 객체들을 런타임 시 연결해주는 작업

의존관계 주입 방법

```
- 생성자 주입 (constructor injection): 객체를 생성하는 시점에 생성자를 통해 의존관계를 주입한다.
- 설정자 주입 (setter injection) : 객체 생성 후 setter 메서드를 통해 의존관계를 주입한다.
- 메서드 주입 (method injection) : 메서드 실행 시 인자를 이용해 의존관계를 주입한다.
```
