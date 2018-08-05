package com.example.tuancan.service;

import com.example.tuancan.dto.RecipeAndQuantity;

import java.util.Date;
import java.util.List;

public interface OrderQuantityService {

    public List<RecipeAndQuantity> getUnitAndOrder(Integer id,Date date);
}
