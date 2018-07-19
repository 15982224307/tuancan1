package com.example.tuancan.dao;

import com.example.tuancan.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnswerMapper {

    @Select("select * from answer where answer_id=#{id}")
    public Answer selectOne(Integer id);
}
