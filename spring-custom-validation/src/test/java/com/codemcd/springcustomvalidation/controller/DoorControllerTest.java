package com.codemcd.springcustomvalidation.controller;

import com.codemcd.springcustomvalidation.dto.PersonDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class DoorControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void invalid_one() throws JsonProcessingException {
        PersonDto person = PersonDto.builder()
                .name(null)
                .age(28)
                .birthday("20200803").build();

        ObjectMapper om = new ObjectMapper();
        String inputJson = om.writeValueAsString(person);
        System.out.println(inputJson);

        webTestClient.post().uri("/person")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(inputJson), String.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$").isEqualTo(false)
        ;
    }

    @Test
    @DisplayName("@Valid를 사용하여 List 유효성 검사를 하며, 정상적인 입력인 경우")
    void valid_list() throws JsonProcessingException {
        PersonDto person1 = PersonDto.builder()
                .name("park")
                .age(28)
                .birthday("20200803").build();
        PersonDto person2 = PersonDto.builder()
                .name("kim")
                .age(25)
                .birthday("20200103").build();
        PersonDto person3 = PersonDto.builder()
                .name("Lee")
                .age(30)
                .birthday("20200703").build();

        List<PersonDto> people = Arrays.asList(person1, person2, person3);
        ObjectMapper om = new ObjectMapper();
        String inputJson = om.writeValueAsString(people);
        System.out.println(inputJson);

        webTestClient.post().uri("/people")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(inputJson), String.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$").isEqualTo(true)
        ;
    }

    @Test
    @DisplayName("@Valid를 사용하여 List 유효성 검사를 하며, null 입력인 경우")
    void invalid_list() throws JsonProcessingException {
        PersonDto person1 = PersonDto.builder()
                .name(null)
                .age(28)
                .birthday("20200803").build();
        PersonDto person2 = PersonDto.builder()
                .name("kim")
                .age(25)
                .birthday("20200103").build();
        PersonDto person3 = PersonDto.builder()
                .name("Lee")
                .age(30)
                .birthday(null).build();

        List<PersonDto> people = Arrays.asList(person1, person2, person3);
        ObjectMapper om = new ObjectMapper();
        String inputJson = om.writeValueAsString(people);

        webTestClient.post().uri("/people")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(inputJson), String.class)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$").isEqualTo(false)
        ;
    }
}

