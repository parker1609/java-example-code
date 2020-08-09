# Spring Custom Validation

## 목표
Spring MVC 환경에서 `@RequestBody`를 통해 파라미터로 List와 같은 컬렉션이 왔을 때 유효성 검사하기.

`@Valid`를 사용할 때는 단일 객체에만 적용된다. List와 같은 컬렉션인 경우 내부 객체가 아닌 List 자체에 유효성 검사를 하기 때문에 원하는대로 동작하지 않는다.


## 환경
- Spring Boot 2.3
- Java 8
- **Hibernate-Validator 5.3.4**
- lombok
- JUnit5
- webTestClient(web-flux)


## 개발
구글링을 통해 기존의 2가지 방법정도를 적용해보았는데, 정상적으로 동작하지 않아서 조금 수정을 했다.
- CustomValidator 클래스 만들기
    - <https://gompangs.tistory.com/entry/Spring-Valid-Collection-Validation-%EA%B4%80%EB%A0%A8>
    - <https://medium.com/chequer/valid-%EC%95%A0%EB%84%88%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%EC%BB%AC%EB%A0%89%EC%85%98-%ED%83%80%EC%9E%85-requestbody%EC%97%90-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-6aef15bb8dff>
- `@Valid`를 적용한 래핑 컬렉션 클래스 만들
    - <https://stackoverflow.com/questions/28150405/validation-of-a-list-of-objects-in-spring>


위는 참고한 내용들이다.

하지만 모두 적용되지 않았다. 그래서 첫 번째 방법을 조금 수정해서 사용했다. 문제라고 생각된 부분은 Custom Validator는 이미 요청된 JSON 파일을 `List<>`
로 매핑한 이후에 동작하였다. 따라서 `CustomCollectionValidator`의 `validate()` 메서드에서 `errors`에는 정상적으로 유효하지 않은 입력에 대한
예외가 저장되는데 이를 처리하지 않았다. 그래서 간단히 Error가 존재할 때 Custom RuntimeException을 만들어 던져주었다.

던져진 예외는 `ControllerAdvice`에서 잡아 처리하였다. 