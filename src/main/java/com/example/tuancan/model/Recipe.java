package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    /*  食谱编号  */
    private Integer recipeId;

    /*  食谱分类编号  */
    private Integer recipeTypeId;

    /*  公司编号  */
    private Integer deliveringCompanyNo;

    /*  食谱名称  */
    private String recipeName;

    /*  原料  */
    private String recipeMaterial;

    /*  辅料辅料  */
    private String recipeAccessorie;

    /*  加工流程  */
    private String recipeProcessing;

    /*  荤素标志（1：荤菜，2：素菜））  */
    private int recipeMeatOrVegetable;

    /*  菜品类型（1：炒菜，2：凉菜，3：汤菜，4：蒸菜，5：烧菜） */
    private int recipeType;

    /*  是否糕点（0：不是,1：是）  */
    private int recipeIsCakes;

    /*  菜品特色  */
    private String recipeCharacter;

    /*  适合人群  */
    private String recipePeople;

    /*  食谱图标  */
    private String recipeIcon;

    /*  成本单价  */
    private BigDecimal recipeCostprice;

    /*  食谱状态(0：不可用，1：可用)  */
    private int recipeStatus;

    /*  创建者   */
    private String recipeOwner;

    /* 创建日期  */
    private Date recipeCreatedate;

}
