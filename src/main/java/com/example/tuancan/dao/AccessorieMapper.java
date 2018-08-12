package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AccessorieMapper extends Mapper<Accessorie> {

    /*  根据编号查询单个结果*/
    @Select("select * from accessorie where accessorie_no =#{id}")
    @Results(id="getone",value = {

            @Result(column = "Foodmaterial_id",property = "foodMaterial",javaType = FoodMaterial.class,
                    one = @One(select = "com.example.tuancan.dao.FoodMaterialMapper.selectByPrimaryKey")),
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))
    })
    public Accessorie selectOneByNo(Integer id);

    /*  根据食材编号查询结果
    * */
    @Select("select * from accessorie where Foodmaterial_id =#{id}")
    @ResultMap(value = "getone")
    public List<Accessorie> selectOneByFoodId(Integer id);

//    /*  根据食材编号查询结果
//   * */
//    @Select("select * from accessorie where Foodmaterial_id =#{id}")
//    @ResultMap(value = "getone")
//    public List<Accessorie> selectOneByFoodId(Integer id);

    /*  所有结果*/
    @Select("select * from accessorie ")
    @ResultMap(value = "getone")
    public List<Accessorie> getAll();

    /*  根据食谱编号查询结果*/
    @Select("select * from accessorie where recipe_id =#{id}")
    @ResultMap(value = "getone")
    public List<Accessorie> selectOneByRecipeId(Integer id);

    /*插入数据*/
    @Insert("insert into accessorie values(#{foodMaterial.foodmaterialId},#{recipe.recipeId},#{accessorieNo},#{accessorieWeight},#{accessorieMemo})")
    public int insertOne(Accessorie accessorie);

    /*插入数据*/
    @Update("update  accessorie set Foodmaterial_id = #{foodMaterial.foodmaterialId}," +
            "recipe_id = #{recipe.recipeId}, accessorie_weight = #{accessorieWeight}," +
            "accessorie_memo = #{accessorieMemo} where accessorie_no = #{accessorieNo}")
    public int updateOne(Accessorie accessorie);




}
