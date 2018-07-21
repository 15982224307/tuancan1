package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "menudetail")
public class MenuDetail implements Serializable{

    /*  团餐菜单,获取编号  */


    private GroupMealMenumaster groupMealMenumasterId;

    /*  食谱,获取食谱编号  */


    private Recipe recipeId;

    /*  菜单序号  */
    @Column(name = "MenuDetail_no")
    private Integer menuDetailNo;

    /*  备注  */
    @Column(name = "MenuDetail_mome")
    private String menuDetailMome;

}
