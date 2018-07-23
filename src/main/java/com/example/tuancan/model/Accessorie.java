package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accessorie")
public class Accessorie {

    /*食材 ，获取编号*/
    private FoodMaterial foodMaterial;

    /*食谱，获取编号*/
    private Recipe recipe;

    /*辅料编号*/
    @Column(name = "accessorie_no")
    private Integer accessorieNo;

    /*辅料重量（可以是克，也可以是少许等不确定）*/
    @Column(name = "accessorie_weight")
    private String accessorieWeight;

    /*辅料备注*/
    @Column(name = "accessorie_memo")
    private String accessorieMemo;
}
