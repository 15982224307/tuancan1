package com.example.tuancan.service.impl;

import com.example.tuancan.dao.OrderQuantityMapper;
import com.example.tuancan.dto.RecipeAndQuantity;
import com.example.tuancan.dto.UnitAndOrder;
import com.example.tuancan.service.OrderQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderQuantityServiceImpl implements OrderQuantityService {

    @Autowired
    private OrderQuantityMapper orderQuantityMapper;

    @Override
    public List<RecipeAndQuantity> getUnitAndOrder(Integer id,Date date) {
        return orderQuantityMapper.getUnitAndOrder(id,date);
    }
}
