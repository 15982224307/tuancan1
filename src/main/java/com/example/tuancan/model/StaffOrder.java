package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stafforder")
public class StaffOrder implements Serializable{

    /* 点餐编号 */
    @Id
    @Column(name = "StaffOrder_id")
    private Integer staffOrderId;

    /*  用餐员工,获取编号 */
    private GroupMealStaff gMStaff;

    /*   食谱,获取编号  */
    private Recipe recipe;

    /*   所属日期   */
    @Column(name = "StaffOrder_usedate")
    private Date staffOrderUsedate;

    /*  点餐日期  */
    @Column(name = "StaffOrder_date")
    private Date staffOrderDate;

}
