package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StaffOrder {

    /* 点餐编号 */
    private Integer staffOrderId;

    /*  用餐员工编号 */
    private Integer gMStaffId;

    /*   食谱编号  */
    private Integer recipeId;

    /*   所属日期   */
    private Date staffOrderUsedate;

    /*  点餐日期  */
    private Date staffOrderDate;

}
