package com.example.tuancan.dto;

import com.example.tuancan.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeAndQuantity {


    /*  食谱编号  */
    private Integer recipeId;

    /*  食谱名称  */
    private String recipeName;

    /*荤素*/
    private Integer recipeMeatOrVegetable;

    /*点餐数量*/
    private Integer quantity;
}
