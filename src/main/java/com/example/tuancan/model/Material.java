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
@Table(name = "material")
public class Material {

    /*食材,获取编号*/
    private FoodMaterial foodMaterial;

    /*食谱,获取编号*/
    private Recipe recipe;

    /*原料序号（用于排序）*/
    @Column(name = "material_no")
    private Integer materialNo;

    /*原料的重量(克为单位)*/
    @Column(name = "material_weight")
    private Integer materialWeight;

    /*备注*/
    @Column(name = "material_memo")
    private String materialMemo;
}
