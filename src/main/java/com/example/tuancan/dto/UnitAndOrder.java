package com.example.tuancan.dto;

import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitAndOrder {

    /*公司id*/
    private Integer UnitID;

    /*公司name*/
    private String UnitName;

    /*合同荤素数量*/
    private int hun_number;

    private int su_number;
    
    /*餐标单价*/
    private BigDecimal prrice;

    /*点餐人数*/
    private int people;

    /*荤素食谱*/
    private List<RecipeAndQuantity> hun_recipes;

    private List<RecipeAndQuantity> su_recipes;




}
