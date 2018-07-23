package com.example.tuancan.service;

import com.example.tuancan.model.Accessorie;
import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.model.Recipe;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccessorieService {

    /**
     *  根据编号查询单个结果*/
    public Accessorie selectOneByNo(Integer id);

    /**
     *  所有结果*/
    public List<Accessorie> getAll();
    /**
     *  根据食材编号查询结果*/
   public List<Accessorie> selectOneByFoodId(Integer id);

    /**
     *  根据食谱编号查询结果*/
    public List<Accessorie> selectOneByRecipeId(Integer id);

    /**
     * 插入数据*/
    public int insertOne(Accessorie accessorie);

    /**
     * 插入数据*/
     public int updateOne(Accessorie accessorie);
}
