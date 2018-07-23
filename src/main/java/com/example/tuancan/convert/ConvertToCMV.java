package com.example.tuancan.convert;


import com.example.tuancan.dto.CommendOrMealOrVegetable;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.model.TomorrowMenudetail;
import com.example.tuancan.utils.Constants;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ConvertToCMV {
    /**
     *将一些数据转化为微信点餐前台所需 数据
     */
    public static CommendOrMealOrVegetable convertCommendOrMealOrVegetable(List<TomorrowMenudetail> tomorrowMenudetails,
                                             DeliveringCompany deliveringCompany,  GroupMealUnit unit){
        CommendOrMealOrVegetable commendOrMealOrVegetable = new CommendOrMealOrVegetable();


        try {
            for (TomorrowMenudetail t:tomorrowMenudetails){
                //推荐菜
                if (t.getTomorrowMenuIsRecommend()==Constants.Public.RECOMMEND){
                    commendOrMealOrVegetable.getCommends().add(t.getRecipe());
                }
                //荤菜
                if(t.getRecipe().getRecipeMeatOrVegetable()== Constants.Public.MEAL){

                    commendOrMealOrVegetable.getMeals().add(t.getRecipe());
                    //素菜
                }else if (t.getRecipe().getRecipeMeatOrVegetable()== Constants.Public.VEGETABLES){
                    commendOrMealOrVegetable.getVeges().add(t.getRecipe());
                }
            }
            commendOrMealOrVegetable.setAddress(deliveringCompany.getDeliveringCompanyAddress());
            commendOrMealOrVegetable.setTel(deliveringCompany.getDeliveringCompanyTel());
            commendOrMealOrVegetable.setUnitname(deliveringCompany.getDeliveringCompanyName());
            commendOrMealOrVegetable.setStaffName(unit.getGroupMealUnitName());

        }catch (Exception e){
            log.info("error:"+e.getMessage());
        }


        return commendOrMealOrVegetable;
    }
}
