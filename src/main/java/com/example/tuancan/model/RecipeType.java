package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipetype")
public class RecipeType implements Serializable{

    /*  食谱分类编号  */
    @Id
    @Column(name = "RecipeType_id")
    private Integer recipeTypeId;

    /*  菜系名称  */
    @Column(name = "RecipeType_name")
    private String  recipeTypeName;

    /*  菜系简介  */
    @Column(name = "RecipeType_disc")
    private String recipeTypeDisc;

    /*  创建日期  */
    @Column(name = "RecipeType_createdate")
    private Date recipeTypeCreatedate;
}
