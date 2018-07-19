package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MenuDetail {

    /*  团餐菜单编号  */
    private Integer groupMealMenumasterId;

    /*  食谱编号  */
    private Integer recipeId;

    /*  菜单序号  */
    private Integer menuDetailNo;

    /*  备注  */
    private String menuDetailMome;

}
