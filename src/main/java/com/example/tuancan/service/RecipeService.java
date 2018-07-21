package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.model.RecipeType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecipeService {

    /*id查询*/
    public Recipe selectOneById(Integer id);

    /*分类编号查询*/
    public List<Recipe> selectByTypeId(Integer id);

    /*公司编号查询*/
    public List<Recipe> selectByCompanyId(Integer companyid);

    /*食谱名称模糊查询*/
    public List<Recipe> slectByLikeName(String name);

    /*荤素查询*/
     public List<Recipe> slectByMeatOrVegetable(int meatorvegetable);

    /*菜品类型查询*/
     public List<Recipe> slectByRecipeType(int type);

    /*菜品类型查询*/
     public List<Recipe> slectByIsCakes(int iscakes);

    /*适合人群查询*/
    public List<Recipe> slectByPeople(String people);

    /*菜品类型查询*/
     public List<Recipe> slectByStatus(int status);

    /*菜品类型查询*/
    public List<Recipe> slectByOwner(String owner);

    /*按单价排序查询*/
    public List<Recipe> slectOrderByCostPrice();

    /*创建时间排序查询*/
   public List<Recipe> slectOrderByCreateDate();

    /*全部查询*/
    public List<Recipe> getAll();

    /*增加数据*/
    public int insertOne(Recipe recipe);

    /*删除数据*/
     public int deleteOneById(Integer id);


    /*更新数据*/
    public int updateOne(Recipe recipe);
}
