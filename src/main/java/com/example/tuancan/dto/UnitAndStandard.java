package com.example.tuancan.dto;

import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UnitAndStandard {

    /*公司id*/
    private Integer UnitID;

    /*公司name*/
    private String UnitName;

    /*餐标*/
    private DiningStandard diningStandard;

    /*合同荤素数量*/
    private int hun_number;

    private int su_number;

    /*荤菜*/
    private Map<Integer,String> huncai;

    /*素菜*/
    private Map<Integer,String>sucai;

    /*是否已经添加*/
    private Integer added;

}
