package com.codemcd.springbootmybatisstart.domain;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class City {
    private Long id;
    private String name;
    private String country;
    private Long population;

    @Builder
    public City(String name, String country, Long population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }
}
