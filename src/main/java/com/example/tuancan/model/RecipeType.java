package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RecipeType {

    /*  食谱分类编号  */
    private Integer recipeTypeId;

    /*  菜系名称  */
    private String  recipeTypeName;

    /*  菜系简介  */
    private String recipeTypeDisc;

    /*  创建日期  */
    private Date recipeTypeCreatedate;
}
