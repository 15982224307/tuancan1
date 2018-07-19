package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class QuestionNaire {

    /*  问卷编号  */
    private Integer questionnaireId;

    /*  问题描述  */
    private String questionnaireDisc;

    /*  类型（1：单选，2：多选，3：主管题） */
    private int questionnaireType;

    /*  选择A  */
    private String questionnaireChoiceA;

    /*  选择B  */
    private String questionnaireChoiceB;

    /*  选择C  */
    private String questionnaireChoiceC;

    /*  选择D  */
    private String questionnaireChoiceD;


}
