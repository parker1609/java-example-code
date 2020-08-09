# Spring Boot + Mybatis 시작하기

## 목표
Spring Boot와 Mybatis 환경 설정 및 테스트 환경 구축


## 개발 환경
- Spring Boot 2.3.2
- Mybatis
- lombok
- H2
- **mybatis-spring-boot-starter-test**
    - 테스트 환경에서 `@MybatisTest` 어노테이션을 사용하기 위함(최대한 필요한 Bean만 올리기 위함)
    

## 환경 설정 과정
### @MapperScan(basePackages = "com.codemcd.springbootmybatisstart")
스프링 마이바티스는 `@Mapper`를 통해 데이터에 접근한다. 스프링 마이바티스는 내부적으로 쓰레드에 안전한 매퍼를 만들어준다. 
프로젝트에서 `@Mapper`를 만드는 경로를 등록해주어야 하는데, 스프링 프로젝트의 시작점에 위 어노테이션과 mapper의 위치를 적는다.

- <https://mybatis.org/spring/ko/mappers.html>
- <https://bigstupid.tistory.com/23>

### <mapper namespace="com.codemcd.springbootmybatisstart.mapper.CityMapper">
실제 SQL을 작성하는 `.xml` 파일에 사용할  Mapper Interface를 위와 같이 선언한다.

### mybatis.mapper-locations=mapper/*.xml
application.properties 또는 application.yml 파일에 실제 Mybatis의 SQL을 담는 mapper XML 파일의 경로를 설정한다.
기본적으로 `main/resource`로 설정되어 있고, 이 프로젝트처럼 추가적으로 디렉토리를 만든다면 위와 같이 설정을 추가해야한다.

- <https://itcoolly.tistory.com/148>

## 참고자료
- <http://tech.javacafe.io/2018/07/31/mybatis-with-spring/>
- <https://all-record.tistory.com/176>
- <http://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/>  
