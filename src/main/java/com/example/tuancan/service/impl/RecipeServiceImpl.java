package com.example.tuancan.service.impl;

import com.example.tuancan.dao.RecipeMapper;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;

    /*id查询*/
    @Override
    public Recipe selectOneById(Integer id) {
        return recipeMapper.selectOneById(id);
    }


    /*菜谱编号查询*/
    @Override
    public List<Recipe> selectByTypeId(Integer id) {
        return recipeMapper.selectByTypeId(id);
    }

    @Override
    public List<Recipe> selectByCompanyIdAndHunAndByPrice(Integer companyid, BigDecimal price) {
        return recipeMapper.selectByCompanyIdAndHunAndByPrice(companyid,price);
    }

    @Override
    public List<Recipe> selectByCompanyIdAndBySuAndByPrice(Integer companyid, BigDecimal price) {
        return recipeMapper.selectByCompanyIdAndBySuAndByPrice(companyid,price);
    }

    /*公司所属查询*/
    @Override
    public List<Recipe> selectByCompanyId(Integer companyid) {
        return recipeMapper.selectByCompanyId(companyid);
    }

    /*名称模糊查询*/
    @Override
    public List<Recipe> slectByLikeName(String name) {
        return recipeMapper.slectByLikeName(name);
    }

    /*荤素查询*/
    @Override
    public List<Recipe> slectByMeatOrVegetable(int meatorvegetable) {
        return recipeMapper.slectByMeatOrVegetable(meatorvegetable);
    }

    /*类型查询*/
    @Override
    public List<Recipe> slectByRecipeType(int type) {
        return recipeMapper.slectByRecipeType(type);
    }

    /*是否是糕点查询*/
    @Override
    public List<Recipe> slectByIsCakes(int iscakes) {
        return recipeMapper.slectByIsCakes(iscakes);
    }

    /*适合人群查询*/
    @Override
    public List<Recipe> slectByPeople(String people) {
        return recipeMapper.slectByPeople(people);
    }

    /*状态查询*/
    @Override
    public List<Recipe> slectByStatus(int status) {
        return recipeMapper.slectByStatus(status);
    }

    /*创建者查询*/
    @Override
    public List<Recipe> slectByOwner(String owner) {
        return recipeMapper.slectByOwner(owner);
    }

    /*单价排序*/
    @Override
    public List<Recipe> slectOrderByCostPrice() {
        return recipeMapper.slectOrderByCostPrice();
    }

    /*创建日期排序*/
    @Override
    public List<Recipe> slectOrderByCreateDate() {
        return recipeMapper.slectOrderByCreateDate();
    }

    /*所有数据*/
    @Override
    public List<Recipe> getAll() {
        return recipeMapper.getAll();
    }

    /*更新数据*/
    @Override
    public int insertOne(Recipe recipe) {
        return recipeMapper.insertOne(recipe);
    }

    /*删除数据*/
    @Override
    public int deleteOneById(Integer id) {
        return recipeMapper.deleteOneById(id);
    }

    /*插入数据*/
    @Override
    public int updateOne(Recipe recipe) {
        return recipeMapper.updateOne(recipe);
    }
}
