package com.example.tuancan.dao;

import com.example.tuancan.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RecipeMapper extends Mapper<Recipe>{

    /*id查询*/
    @Select("select * from recipe where recipe_id =#{id}")
    @Results(id="getone",value = {
            @Result(column = "RecipeType_id",property = "recipeTypeId",javaType = RecipeType.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeTypeMapper.selectByPrimaryKey")),
            @Result(column = "DeliveringCompany_no",property = "deliveringCompanyNo",javaType = DeliveringCompany.class,
                    one = @One(select = "com.example.tuancan.dao.DeliveringCompanyMapper.selectByPrimaryKey"))
    })
    public Recipe selectOneById(Integer id);

    /*分类编号查询*/
    @Select("select * from recipe where RecipeType_id = #{typeid}")
    @ResultMap(value = "getone")
    public List<Recipe> selectByTypeId(Integer id);

    /*公司编号查询*/
    @Select("select * from recipe where DeliveringCompany_no = #{companyid}")
    @ResultMap(value = "getone")
    public List<Recipe> selectByCompanyId(Integer companyid);

    /*公司编号和菜谱名查询*/
    @Select("select * from recipe where DeliveringCompany_no = #{companyid} and recipe_name = #{name}")
    @ResultMap(value = "getone")
    public Recipe selectByCompanyIdAndName(@Param("companyid") Integer companyid,@Param("name")String name);

    /*公司编号查询荤菜and小于价格*/
    @Select("select * from recipe where DeliveringCompany_no = #{companyid} and recipe_costprice < #{price} and recipe_Meat_or_vegetable = 1")
    @ResultMap(value = "getone")
    public List<Recipe> selectByCompanyIdAndHunAndByPrice(@Param("companyid") Integer companyid,@Param("price") BigDecimal price);


    /*公司编号查询素菜and小于价格*/
    @Select("select * from recipe where DeliveringCompany_no = #{companyid} and recipe_costprice < #{price} and recipe_Meat_or_vegetable = 2")
    @ResultMap(value = "getone")
    public List<Recipe> selectByCompanyIdAndBySuAndByPrice(@Param("companyid") Integer companyid,@Param("price") BigDecimal price);


    /*食谱名称模糊查询*/
    @Select("select * from recipe where recipe_name like '%${value}%'")
    @ResultMap(value = "getone")
    public List<Recipe> slectByLikeName(String name);

    /*荤素查询*/
    @Select("select * from recipe where recipe_Meat_or_vegetable = #{meatorvegetable}")
    @ResultMap(value = "getone")
    public List<Recipe> slectByMeatOrVegetable(int meatorvegetable);

    /*菜品类型查询*/
    @Select("select * from recipe where recipe_type = #{type}")
    @ResultMap(value = "getone")
    public List<Recipe> slectByRecipeType(int type);

    /*菜品类型查询*/
    @Select("select * from recipe where recipe_IsCakes = #{iscakes}")
    @ResultMap(value = "getone")
    public List<Recipe> slectByIsCakes(int iscakes);

    /*适合人群查询*/
    @Select("select * from recipe where recipe_people like '%${value}%'")
    @ResultMap(value = "getone")
    public List<Recipe> slectByPeople(String people);

    /*菜品类型查询*/
    @Select("select * from recipe where recipe_status = #{status}")
    @ResultMap(value = "getone")
    public List<Recipe> slectByStatus(int status);

    /*菜品类型查询*/
    @Select("select * from recipe where recipe_owner = #{owner}")
    @ResultMap(value = "getone")
    public List<Recipe> slectByOwner(String owner);


    /*按单价排序查询*/
    @Select("select * from recipe order by recipe_costprice ASC")
    @ResultMap(value = "getone")
    public List<Recipe> slectOrderByCostPrice();

    /*创建时间排序查询*/
    @Select("select * from recipe order by recipe_createdate DESC")
    @ResultMap(value = "getone")
    public List<Recipe> slectOrderByCreateDate();

    /*全部查询*/
    @Select("select * from recipe ")
    @ResultMap(value = "getone")
    public List<Recipe> getAll();

    /*增加数据*/
    @Insert("insert into recipe values(null,#{recipeTypeId.recipeTypeId},#{deliveringCompanyNo.deliveringCompanyNo},#{recipeName}" +
            ",#{recipeMaterial},#{recipeAccessorie},#{recipeProcessing},#{recipeMeatOrVegetable}," +
            "#{recipeType},#{recipeIsCakes},#{recipeCharacter},#{recipePeople},#{recipeIcon}," +
            "#{recipeCostprice},#{recipeStatus},#{recipeOwner},#{recipeCreatedate})")

    public int insertOne(Recipe recipe);

    /*删除数据*/
    @Delete("delete  from recipe where recipe_id = #{id} ")
    public int deleteOneById(Integer id);


    /*更新数据*/
    @Update("update  recipe set RecipeType_id = #{recipeTypeId.recipeTypeId},DeliveringCompany_no = #{deliveringCompanyNo.deliveringCompanyNo},recipe_name = #{recipeName}" +
            ",recipe_material = #{recipeMaterial},recipe_accessorie = #{recipeAccessorie},recipe_processing = #{recipeProcessing},recipe_Meat_or_vegetable= #{recipeMeatOrVegetable},recipe_type = #{recipeType}," +
            "recipe_IsCakes = #{recipeIsCakes},recipe_character = #{recipeCharacter},recipe_people = #{recipePeople},recipe_icon = #{recipeIcon},recipe_costprice = #{recipeCostprice}," +
            "recipe_status = #{recipeStatus},recipe_owner = #{recipeOwner},recipe_createdate = #{recipeCreatedate} where recipe_id = #{recipeId}")

    public int updateOne(Recipe recipe);

}
