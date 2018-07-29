package com.example.tuancan.utils;

import com.example.tuancan.dto.Recipeid_name_privce;
import com.example.tuancan.model.Recipe;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class RecipeUtil {

    public static List<Recipeid_name_privce> getRecipes(List<Recipe> recipe){

        List<Recipeid_name_privce> recipeid_name_privces = new ArrayList<>();
        for(Recipe recipe1 : recipe){
            Recipeid_name_privce recipeid_name_privce = new Recipeid_name_privce();
            recipeid_name_privce.setId(recipe1.getRecipeId());
            recipeid_name_privce.setName(recipe1.getRecipeName());
            recipeid_name_privce.setPrice(recipe1.getRecipeCostprice());

            recipeid_name_privces.add(recipeid_name_privce);
        }
       return recipeid_name_privces;


    }
}
