package com.example.tuancan.dto;

import com.example.tuancan.model.Recipe;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommendOrMealOrVegetable {

    /*推荐食谱，也就是每一道菜*/
    private List<Recipe> commends=new ArrayList<Recipe>();

    /*荤菜食谱，也就是每一道菜*/
    private List<Recipe> meals=new ArrayList<Recipe>();

    /*素菜食谱，也就是每一道菜*/
    private List<Recipe> veges=new ArrayList<Recipe>();

    /*团餐公司名*/
    private String Unitname="";

    /*团餐公司地址*/
    private String address="";

    /*团餐公司办公联系电话*/
    private String tel="";

    /*所在公司名*/
    private String staffName="";


}
