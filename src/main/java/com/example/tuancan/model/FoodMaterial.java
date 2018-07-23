package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foodmaterial")
public class FoodMaterial {

    /*食材编号*/
    @Id
    @Column(name = "Foodmaterial_id")
    private Integer foodmaterialId;

    /*小类编号,获取编号*/
    private Classification classification;

    /*食材名称*/
    @Column(name = "Foodmaterial_name")
    private String oodmaterialName;

    /*食材描述*/
    @Column(name = "Foodmaterial_disc")
    private String foodmaterialDisc;

    /*食材图片*/
    @Column(name = "Foodmaterial_icon")
    private String foodmaterialIcon;

    /*食材创建日期*/
    @Column(name = "Foodmaterial_createdate")
    private Date foodmaterialCreatedate;
}
