package com.example.tuancan.dao;

import com.example.tuancan.dto.RecipeAndQuantity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderQuantityMapper extends Mapper<RecipeAndQuantity>{

    @Select("SELECT b.recipe_id,b.recipe_name,b.recipe_Meat_or_vegetable ,quantity FROM ( " +
            "SELECT recipe_id, COUNT(*) quantity  FROM stafforder WHERE   GMStaff_id IN(SELECT GMStaff_id FROM " +
            "groupmealstaff WHERE GroupMealUnit_id = #{id} and StaffOrder_usedate = #{date} ) GROUP BY recipe_id) a JOIN recipe b ON a.recipe_id = b.recipe_id")
    public List<RecipeAndQuantity> getUnitAndOrder(@Param("id") Integer id, @Param("date")Date date);
}
