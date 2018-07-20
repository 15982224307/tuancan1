package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 等级
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companygrade")
public class CompanyGrade  implements Serializable {

    @Id
    @Column(name = "CompanyGrade_id")
    private Integer companyGradeId ;     //int not null auto_increment comment '等级编号',

    @Column(name = "CompanyGrade_name")
    private String companyGradeName ;   //varchar(64) comment '名称',

    @Column(name = "CompanyGrade_authority")
    private String companyGradeAuthority ;  //varchar(128) comment '功能',

}

