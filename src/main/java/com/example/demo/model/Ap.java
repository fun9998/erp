package com.example.demo.model;

import lombok.Data;
import lombok.ToString;


// 血压
@Data
@ToString
public class Ap {
    private String type;
    private Integer normalnum;;
    private Integer cardionum;;
}
