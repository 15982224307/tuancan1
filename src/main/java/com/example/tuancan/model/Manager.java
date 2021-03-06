package com.example.tuancan.model;

import com.example.tuancan.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 平台管理员
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Serializable{

    /*  管理员编号  */
    @Id
    //@Column(name = "")
    private Integer managerId;

    /*   登录名  */
    private String managerLoginname;

    /*  登录密码  */
    private String managerPassword;

    /*  姓名  */
    private String managerName;

    /*  状态（0：停用，1启用）  */
    private int managerStatus= StatusEnum.StatusUP.getCode();

    /*  电话  */
    private String managerMobile;

    /*  创建日期 */
    @Column(name = "manager_createDate")
    private Date managerCreateDate;


}
