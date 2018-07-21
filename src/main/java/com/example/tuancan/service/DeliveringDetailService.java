package com.example.tuancan.service;

import com.example.tuancan.model.DeliveringDetail;

import java.util.List;

public interface DeliveringDetailService {

    public DeliveringDetail selectByDeliveringDetailNo(String deliveringDetailNo);

    public List<DeliveringDetail> selectByDeliveringMasterId(Integer deliveringMasterId);

    public List<DeliveringDetail> selectByrecipeId(Integer recipeId);

    public int InsertOne(DeliveringDetail deliveringDetail);

    public  int updateOne(DeliveringDetail deliveringDetail);

}
