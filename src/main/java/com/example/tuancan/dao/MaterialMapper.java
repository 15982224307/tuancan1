package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MaterialMapper extends Mapper<Material> {

    /*  根据id 查询单个结果*/
    @Select("select * from material where material_no =#{id}")
    @Results(id="getone",value = {

            @Result(column = "Foodmaterial_id",property = "foodMaterial",javaType = FoodMaterial.class,
                    one = @One(select = "com.example.tuancan.dao.FoodMaterialMapper.selectByPrimaryKey")),
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))
    })
    public Material selectOneById(Integer id);

    /*  根据食材编号查询结果*/
    @Select("select * from material where Foodmaterial_id =#{id}")
    @ResultMap(value = "getone")
    public List<Material> selectOneByFoodId(Integer id);

    /*  所有结果*/
    @Select("select * from material ")
    @ResultMap(value = "getone")
    public List<Material> getAll();

    /*  根据食谱编号查询结果*/
    @Select("select * from material where recipe_id =#{id}")
    @ResultMap(value = "getone")
    public List<Material> selectOneByRecipeId(Integer id);

    /*插入数据*/
    @Insert("insert into material values(#{foodMaterial.foodmaterialId},#{recipe.recipeId},#{materialNo},#{materialWeight},#{materialMemo})")
    public int insertOne(Material material);

    /*插入数据*/
    @Update("update  material set Foodmaterial_id = #{foodMaterial.foodmaterialId}," +
            "recipe_id = #{recipe.recipeId}, material_weight = #{materialWeight}," +
            "material_memo = #{materialMemo} where material_no = #{materialNo}")
    public int updateOne(Material material);

}
