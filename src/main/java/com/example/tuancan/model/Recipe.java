package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipe")
public class Recipe implements Serializable {

    /*  食谱编号  */
    @Id
    @Column(name = "recipe_id")
    private Integer recipeId;

    /*  食谱分类,获取编号  */
    private RecipeType recipeTypeId;

    /*  公司,获取编号  */
    private DeliveringCompany deliveringCompanyNo;

    /*  食谱名称  */
    @Column(name = "recipe_name")
    private String recipeName;

    /*  原料  */
    @Column(name = "recipe_material")
    private String recipeMaterial;

    /*  辅料辅料  */
    @Column(name = "recipe_accessorie")
    private String recipeAccessorie;

    /*  加工流程  */
    @Column(name = "recipe_processing")
    private String recipeProcessing;

    /*  荤素标志（1：荤菜，2：素菜））  */
    @Column(name = "recipe_Meat_or_vegetable")
    private int recipeMeatOrVegetable;

    /*  菜品类型（1：炒菜，2：凉菜，3：汤菜，4：蒸菜，5：烧菜） */
    @Column(name = "recipe_type")
    private int recipeType;

    /*  是否糕点（0：不是,1：是）  */
    @Column(name = "recipe_IsCakes")
    private int recipeIsCakes;

    /*  菜品特色  */
    @Column(name = "recipe_character")
    private String recipeCharacter;

    /*  适合人群  */
    @Column(name = "recipe_people")
    private String recipePeople;

    /*  食谱图标  */
    @Column(name = "recipe_icon")
    private String recipeIcon;

    /*  成本单价  */
    @Column(name = "recipe_costprice")
    private BigDecimal recipeCostprice;

    /*  食谱状态(0：不可用，1：可用)  */
    @Column(name = "recipe_status")
    private int recipeStatus;

    /*  创建者   */
    @Column(name = "recipe_owner")
    private String recipeOwner;

    /* 创建日期  */
    @Column(name = "recipe_createdate")
    private Date recipeCreatedate;

}
