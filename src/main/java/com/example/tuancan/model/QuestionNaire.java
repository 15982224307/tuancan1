package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questionnaire")
public class QuestionNaire {

    /*  问卷编号  */
    @Id
    private Integer questionnaireId;

    /*  问题描述  */
    private String questionnaireDisc;

    /*  类型（1：单选，2：多选，3：主管题） */
    private int questionnaireType;

    /*  选择A  */
    @Column(name = "questionnaire_ChoiceA")
    private String questionnaireChoiceA;

    /*  选择B  */
    @Column(name = "questionnaire_ChoiceB")
    private String questionnaireChoiceB;

    /*  选择C  */
    @Column(name = "questionnaire_ChoiceC")
    private String questionnaireChoiceC;

    /*  选择D  */
    @Column(name = "questionnaire_ChoiceD")
    private String questionnaireChoiceD;


}
