package com.example.tuancan.dao;

import com.example.tuancan.model.DeliveringDetail;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.Recipe;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DeliveringDetailMapper extends Mapper<DeliveringDetail>{

    /**
     * 根据配送明细序号查询
     * @return
     */
    @Select({"select * from delivering_detail where DeliveringDetail_no=#{deliveringDetailNo}"})
    @Results(id = "selectByDeliveringDetailNo",value = {
            @Result(column = "DeliveringMaster_id",property = "deliveringMaster",javaType = DeliveringMaster.class,
            one = @One(select = "com.example.tuancan.dao.DeliveringMasterMapper.selectByPrimaryKey")),
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
            one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))
    })
    public DeliveringDetail selectByDeliveringDetailNo(String deliveringDetailNo);

    /**
     * 根据配送单id查询 其该包含的所有配送明细信息
     * @param deliveringMasterId
     * @return
     */
    @Select({"select * from delivering_detail where DeliveringMaster_id=#{deliveringMasterId}"})
    @Results(id = "selectByDeliveringMasterId",value = {
            @Result(column = "recipe_id",property = "recipe",javaType = Recipe.class,
                    one = @One(select = "com.example.tuancan.dao.RecipeMapper.selectByPrimaryKey"))
    })
    public List<DeliveringDetail> selectByDeliveringMasterId(Integer deliveringMasterId);

    /**
     * 根据食谱id查询 使用该食谱的所有配送明细信息
     * @param recipeId
     * @return
     */
    @Select({"select * from delivering_detail where recipe_id=#{recipeId}"})
    @ResultMap(value = "selectByDeliveringDetailNo")
    public List<DeliveringDetail> selectByrecipeId(Integer recipeId);

    /**
     * 插入数据
     * @param deliveringDetail
     * @return
     */
    @Insert({"insert into delivering_detail(DeliveringDetail_no,DeliveringMaster_id,recipe_id,DeliveringDetail_number,DeliveringDetail_memo) " +
            "values(#{deliveringDetailNo},#{deliveringMaster.deliveringMasterId},#{recipe.recipeId},#{deliveringDetailNumber},#{deliveringDetailMemo})"})
    public int InsertOne(DeliveringDetail deliveringDetail);

    /**
     * 更新数据
     * @param deliveringDetail
     * @return
     */
    @Update({"update delivering_detail set DeliveringMaster_id=#{deliveringMaster.deliveringMasterId},recipe_id=#{recipe.recipeId},DeliveringDetail_number=#{deliveringDetailNumber},DeliveringDetail_memo=#{deliveringDetailMemo} " +
            "where DeliveringDetail_no=#{deliveringDetailNo}"})
    public  int updateOne(DeliveringDetail deliveringDetail);


}
