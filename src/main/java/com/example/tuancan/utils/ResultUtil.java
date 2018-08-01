package com.example.tuancan.utils;

import com.example.tuancan.dto.Result;


public class ResultUtil {

    private ResultUtil(){}

    public static Result status(Integer code,String msg){

        return new Result(code,msg);
    }

    /*public static Result error(String msg){

        return new Result(404,msg);
    }*/
}
