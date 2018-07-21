package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.Recipe;
import com.example.tuancan.model.RecipeType;
import com.example.tuancan.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    /*测试id查询*/
    @Test
    public void selectOneById() throws Exception {
        Recipe recipe = recipeService.selectOneById(1);
        System.out.println(JsonUtil.toJson(recipe));
    }

    /*测试菜品编号查询*/
    @Test
    public void selectByTypeId() throws Exception {
        List<Recipe> recipes = recipeService.selectByTypeId(1);
        System.out.println(JsonUtil.toJson(recipes));
    }


    /*测试公司编号查询*/
    @Test
    public void selectByCompanyId() throws Exception {
        List<Recipe> recipes = recipeService.selectByCompanyId(1);
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试菜名模糊查询*/
    @Test
    public void slectByLikeName() throws Exception {
        List<Recipe> b = recipeService.slectByLikeName("b");
        System.out.println(JsonUtil.toJson(b));
    }

    /*测试荤素查询*/
    @Test
    public void slectByMeatOrVegetable() throws Exception {
        List<Recipe> recipes = recipeService.slectByMeatOrVegetable(2);
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试菜谱类型查询*/
    @Test
    public void slectByRecipeType() throws Exception {
        List<Recipe> recipes = recipeService.slectByRecipeType(2);
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试糕点查询*/
    @Test
    public void slectByIsCakes() throws Exception {
        List<Recipe> recipes = recipeService.slectByIsCakes(1);
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试适合人群*/
    @Test
    public void slectByPeople() throws Exception {
        List<Recipe> recipes = recipeService.slectByPeople("1");
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试状态*/
    @Test
    public void slectByStatus() throws Exception {
        List<Recipe> recipes = recipeService.slectByStatus(2);
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试创建者*/
    @Test
    public void slectByOwner() throws Exception {
        List<Recipe> recipes = recipeService.slectByOwner("2");
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试单价查询*/
    @Test
    public void slectOrderByCostPrice() throws Exception {
        List<Recipe> recipes = recipeService.slectOrderByCostPrice();
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*测试创建时间查询*/
    @Test
    public void slectOrderByCreateDate() throws Exception {
        List<Recipe> recipes = recipeService.slectOrderByCreateDate();
        System.out.println(JsonUtil.toJson(recipes));
    }

    /*所有数据*/
    @Test
    public void getAll() throws Exception {
        List<Recipe> all = recipeService.getAll();
        System.out.println(JsonUtil.toJson(all));
    }


    /*测试插入数据*/
    @Test
    public void insertOne() throws Exception {
        RecipeType recipeType = new RecipeType();
        recipeType.setRecipeTypeId(3);
        DeliveringCompany deliveringCompany = new DeliveringCompany();
        deliveringCompany.setDeliveringCompanyNo(2);
        Recipe recipe = new Recipe();
        recipe.setRecipeTypeId(recipeType);
        recipe.setDeliveringCompanyNo(deliveringCompany);

        int i = recipeService.insertOne(recipe);
        System.out.println(i);

    }

    /*测试删除数据*/
    @Test
    public void deleteOneById() throws Exception {
        int i = recipeService.deleteOneById(4);
        System.out.println(i);
    }

    /*测试更新数据*/
    @Test
    public void updateOne() throws Exception {
        Recipe recipe = recipeService.selectOneById(4);
        recipe.setRecipeName("fg");
        int i = recipeService.updateOne(recipe);
        System.out.println(i);
    }

}