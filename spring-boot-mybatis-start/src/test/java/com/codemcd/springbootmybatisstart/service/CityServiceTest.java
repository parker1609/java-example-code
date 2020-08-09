package com.codemcd.springbootmybatisstart.service;

import com.codemcd.springbootmybatisstart.domain.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@MybatisTest
@Transactional
@Import(CityService.class)
public class CityServiceTest {
    private static final Logger log = LoggerFactory.getLogger(CityServiceTest.class);

    @Autowired
    CityService service;

    @Test
    public void getCityById() {
        City city = service.getCityById(1L);
        log.info("city : {}", city);
    }

    @Test
    public void getAllCity() {
        List<City> cities = service.getAllCity();
        log.info("cities : {}", cities);
    }


    @Test
    public void addCities() {
        service.addCity(new City("뉴욕", "미국", 1_000_000L));
        service.addCity(new City("런던", "영국", 2_000_000L));
        service.addCity(new City("파리", "프랑스", 3_000_000L));
    }
}
