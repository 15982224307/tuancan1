package com.example.tuancan.dao;

import com.example.tuancan.model.Answer;
import com.example.tuancan.model.GroupMealStaff;
import com.example.tuancan.model.QuestionNaire;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AnswerMapper extends Mapper<Answer>{
    /**
     * 此地址有详细介绍@Results用法总结
     * https://blog.csdn.net/cherlshall/article/details/80950150
     * 测试此方法后打印打印结果
     * Answer(answerId=1,
     * gMStaffId=GroupMealStaff(gMStaffId=1, groupMealUnitId=null, gMStafMobile=12312344, gMStaffName=ZHANGSAN, gMStaffStatus=1, gMStaffSex=nan, gMStafIsdefualt=1, gMStafLoginname=xiao, gMStafPassword=123, unitTickerId=dafasfaewr, gMStaffOpenId=QWQqwesew, gMStafCreateDate=2018-07-19)
     * ,questionnaireId=QuestionNaire(questionnaireId=1, questionnaireDisc=sdgasgasdsf, questionnaireType=0, questionnaireChoiceA=A, questionnaireChoiceB=B, questionnaireChoiceC=C, questionnaireChoiceD=D),
     * answerText=nnishishabi, answerDate=2018-07-19 21:50:04.0)2018-07-20 00:06:09.454  INFO 8716 --- [       Thread-3] o.s.w.c.s.GenericWebApplicationContext
     */
    @Select({"select * from answer where answer_id =#{id}"})
    @Results(id="getone",value = {
            @Result(column = "GMStaff_id",property = "gMStaffId",javaType = GroupMealStaff.class,
                    one = @One(select = "com.example.tuancan.dao.GroupMealStaffMapper.selectByPrimaryKey")),
            @Result(column = "questionnaire_id",property = "questionnaireId",javaType = QuestionNaire.class,
                    one = @One(select = "com.example.tuancan.dao.QuestionNaireMapper.selectByPrimaryKey"))
    })
    public Answer getone(Integer id);

    //@Select("SELECT a.*,g.*,q.* FROM answer a LEFT JOIN groupmealstaff g ON a.GMStaff_id=g.GMStaff_id LEFT JOIN questionnaire q ON a.questionnaire_id=q.questionnaire_id")
    public List<Answer> getAll();

}
