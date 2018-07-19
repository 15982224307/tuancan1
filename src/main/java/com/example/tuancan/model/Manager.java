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
public class Manager {

    /*  管理员编号  */
    private Integer managerId;

    /*   登录名  */
    private String managerLoginname;

    /*  登录密码  */
    private String managerPassword;

    /*  姓名  */
    private String managerName;

    /*  状态（0：停用，1启用）  */
    private int managerStatus;

    /*  电话  */
    private String managerMobile;

    /*  创建日期 */
    private Date managerCreateDate;


}
