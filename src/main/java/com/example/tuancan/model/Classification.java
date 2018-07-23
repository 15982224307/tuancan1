package com.example.tuancan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classification")
public class Classification {

    /*小类编号*/
    @Id
    @Column(name = "classification_id")
    private Integer classificationId;

    /*食材主类编号,获取主类编号*/
    private MainCategorie cascadeType;

    /*小类名称*/
    @Column(name = "classification_name")
    private String classificationName;

}
