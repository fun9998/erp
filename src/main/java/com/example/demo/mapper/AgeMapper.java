package com.example.demo.mapper;


import com.example.demo.model.Age;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AgeMapper {
    @Select("select * from age")
    List<Age> selectAll();
}
