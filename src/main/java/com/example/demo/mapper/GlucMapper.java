package com.example.demo.mapper;


import com.example.demo.model.Gluc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GlucMapper {
    @Select("select * from gluc")
    List<Gluc> selectAll();
}
