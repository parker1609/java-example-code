package com.codemcd.springcustomvalidation.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class PersonDto {

    @NotNull
    private String name;

    private int age;

    @NotNull
    private String birthday;

    @Builder
    public PersonDto(String name, int age, String birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}
