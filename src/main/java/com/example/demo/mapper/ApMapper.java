package com.example.demo.mapper;


import com.example.demo.model.Ap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ApMapper {
    @Select("select * from ap")
    List<Ap> selectAll();
}
