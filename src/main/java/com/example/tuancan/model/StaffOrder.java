package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StaffOrder implements Serializable{

    /* 点餐编号 */
    private Integer staffOrderId;

    /*  用餐员工,获取编号 */
    private GroupMealStaff gMStaffId;

    /*   食谱,获取编号  */
    private Recipe recipeId;

    /*   所属日期   */
    private Date staffOrderUsedate;

    /*  点餐日期  */
    private Date staffOrderDate;

}
