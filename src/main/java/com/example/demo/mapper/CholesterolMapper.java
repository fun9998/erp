package com.example.demo.mapper;


import com.example.demo.model.Age;
import com.example.demo.model.Cholesterol;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CholesterolMapper {
    @Select("select * from cholesterol")
    List<Cholesterol> selectAll();
}
