package com.example.tuancan.service;

import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.model.Material;
import com.example.tuancan.model.Recipe;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MaterialService {
    /**
     *  根据id 查询单个结果*/
   public Material selectOneById(Integer id);

    /**
     *  根据食材编号查询结果*/
    public List<Material> selectOneByFoodId(Integer id);

    /**
     *  所有结果*/
   public List<Material> getAll();

    /**
     *  根据食谱编号查询结果*/
   public List<Material> selectOneByRecipeId(Integer id);

    /**
     * 插入数据*/
    public int insertOne(Material material);

    /**
     * 插入数据*/
     public int updateOne(Material material);
}
