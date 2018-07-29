package com.example.tuancan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipeid_name_privce {

    /*食谱id*/
    private Integer id;

    /*食谱name*/
    private String name;

    /*食谱成本单价*/
    private BigDecimal price;




}
