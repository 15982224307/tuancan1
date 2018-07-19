package com.example.tuancan.dao;

import com.example.tuancan.model.Answer;
import com.example.tuancan.model.GroupMealStaff;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AnswerMapper extends Mapper<Answer>{

    @Select("select * from answer where answer_id =#{id}")
    public Answer getone(Integer id);


}
