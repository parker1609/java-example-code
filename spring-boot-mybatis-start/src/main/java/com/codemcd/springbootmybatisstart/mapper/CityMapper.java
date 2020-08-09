package com.codemcd.springbootmybatisstart.mapper;

import com.codemcd.springbootmybatisstart.domain.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {
    City selectCityById(Long id);
    List<City> selectAllCity();
    void insertCity(City city);
}
