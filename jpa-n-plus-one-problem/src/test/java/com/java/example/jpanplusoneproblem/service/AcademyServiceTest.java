package com.java.example.jpanplusoneproblem.service;

import com.java.example.jpanplusoneproblem.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AcademyServiceTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AcademyService academyService;

    @AfterEach
    public void cleanAll() {
        academyRepository.deleteAll();
        teacherRepository.deleteAll();
    }

    @BeforeEach
    public void setup() {
        List<Academy> academies = new ArrayList<>();
        Teacher teacher = teacherRepository.save(new Teacher("선생님"));

        for (int i = 0; i < 10; i++) {
            Academy academy = Academy.builder()
                    .name("강남스쿨" + i)
                    .build();

            academy.addSubject(Subject.builder().name("자바웹개발" + i).teacher(teacher).build());
            academy.addSubject(Subject.builder().name("파이썬자동화" + i).teacher(teacher).build()); // Subject 추가
            academies.add(academy);
        }

        academyRepository.saveAll(academies);
    }

    @Test
    @DisplayName("Academy 여러 개를 조회시 Subject 가 N + 1개의 쿼리가 발생한다.")
    void n_plus_one_problem() {
        //given
        List<String> subjectNames = academyService.findAllSubjectNames();

        //then
        assertThat(subjectNames.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("Academy 여러 개를 joinFetch 로 가져온다.")
    public void solve1_joinFetch() throws Exception {
        //given
        List<Academy> academies = academyRepository.findAllJoinFetch();
        List<String> subjectNames = academyService.findAllSubjectNamesByJoinFetch();

        //then
        assertThat(academies.size()).isEqualTo(20); // 20개가 조회!?
        assertThat(subjectNames.size()).isEqualTo(20); // 20개가 조회!?
    }

    @Test
    @DisplayName("Academy 여러 개를 EntityGraph 로 가져온다")
    public void solve2_entityGraph() throws Exception {
        //given
        List<Academy> academies = academyRepository.findAllEntityGraph();
        List<String> subjectNames = academyService.findAllSubjectNamesByEntityGraph();

        //then
        assertThat(academies.size()).isEqualTo(20);
        assertThat(subjectNames.size()).isEqualTo(20);
    }

    @Test
    @DisplayName("Academy 여러 개를 distinct 해서 가져온다.")
    public void solve_with_distinct () throws Exception {
        //given
        System.out.println("조회 시작");
        List<Academy> academies = academyRepository.findAllJoinFetchDistinct();

        //then
        System.out.println("조회 끝");
        assertThat(academies.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("Academy, Subject, Teacher 를 한번에 가져온다")
    public void join_fetch_all() throws Exception {
        //given
        System.out.println("조회 시작");
        List<Teacher> teachers = academyRepository.findAllWithTeacher().stream()
                .map(a -> a.getSubjects().get(0).getTeacher())
                .collect(Collectors.toList());

        //then
        System.out.println("조회 끝");
        assertThat(teachers.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("Academy, Subject, Teacher 를 EntityGraph 로 한번에 가져온다.")
    public void entity_graph_all() throws Exception {
        //given
        System.out.println("조회 시작");
        List<Teacher> teachers = academyRepository.findAllEntityGraphWithTeacher().stream()
                .map(a -> a.getSubjects().get(0).getTeacher())
                .collect(Collectors.toList());

        //then
        System.out.println("조회 끝");
        assertThat(teachers.size()).isEqualTo(10);
        assertThat(teachers.get(0).getName()).isEqualTo("선생님");

    }
}
