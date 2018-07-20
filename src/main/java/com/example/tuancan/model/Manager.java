package com.example.tuancan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "manager_id")
    /*  管理员编号  */
    private Integer managerId;

    /*   登录名  */
    @Column(name = "manager_loginname")
    private String managerLoginname;

    /*  登录密码  */
    @Column(name = "manager_password")
    private String managerPassword;

    /*  姓名  */
    @Column(name = "manager_name")
    private String managerName;

    /*  状态（0：停用，1启用）  */
    @Column(name = "manager_status")
    private int managerStatus;

    /*  电话  */
    @Column(name = "manager_mobile")
    private String managerMobile;

    /*  创建日期 */
    @Column(name = "manager_createDate")
    private Date managerCreateDate;


}
