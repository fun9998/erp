package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cardio {
    private Integer id;
    private Double age;
    private Integer gender;
    private Double height;
    private Double weight;
    private Integer ap_hi;
    private Integer ap_lo;
    private Integer cholesterol;
    private Integer gluc;
    private Integer smoke;
    private Integer alco;
    private Integer active;
    private Integer cardio;
}
