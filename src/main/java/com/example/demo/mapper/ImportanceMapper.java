package com.example.demo.mapper;


import com.example.demo.model.Importance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ImportanceMapper {
    @Select("select * from importance")
    List<Importance> selectAll();
}
