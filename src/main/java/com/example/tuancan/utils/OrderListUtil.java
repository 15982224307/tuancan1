package com.example.tuancan.utils;

import com.example.tuancan.dto.RecipeAndQuantity;
import com.example.tuancan.dto.UnitAndOrder;
import com.example.tuancan.model.*;
import com.example.tuancan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public  class OrderListUtil {


    /*总点餐人数*/
    public static int getPeopleNumber(List<RecipeAndQuantity>unitAndOrders){
        int num = 0;
        for(RecipeAndQuantity recipeAndQuantity : unitAndOrders){
            num += recipeAndQuantity.getQuantity();
        }
        return num;
    }


    /*封装好的食谱和点餐人数*/
    public  static List<RecipeAndQuantity> getOrderList(Integer hunsu,List<RecipeAndQuantity>unitAndOrders){
        List<RecipeAndQuantity> orderList = new ArrayList<>();

        for(RecipeAndQuantity recipeAndQuantity : unitAndOrders){
            if(recipeAndQuantity.getRecipeMeatOrVegetable() == hunsu){
                orderList.add(recipeAndQuantity);
                Collections.sort(orderList, new Comparator<RecipeAndQuantity>() {
                    @Override
                    public int compare(RecipeAndQuantity o1, RecipeAndQuantity o2) {
                        int q1 = o1.getQuantity();
                        int q2 = o2.getQuantity();
                        if(q1 > q2){
                            return -1;
                        }else if(q1 == q2){
                            return 0;
                        }else {
                            return 1;
                        }
                    }
                });
            }
        }
        return orderList;
    }

}
