package com.example.tuancan.dao;

import com.example.tuancan.model.QuestionNaire;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface QuestionNaireMapper extends Mapper<QuestionNaire>{

    @Select("select * from questionnaire where questionnaire_disc like CONCAT (CONCAT('%',#{disc}),'%')")
    public List<QuestionNaire> selectByDisc(String disc);

    @Select("select * from questionnaire where questionnaire_type=#{type}")
    public List<QuestionNaire> selectByType(int type);
}
