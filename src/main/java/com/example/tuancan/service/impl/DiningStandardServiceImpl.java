package com.example.tuancan.service.impl;

import com.example.tuancan.dao.DiningStandardMapper;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.service.DiningStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DiningStandardServiceImpl implements DiningStandardService{

    @Autowired
    private DiningStandardMapper diningStandardMapper;

    /**
     * 根据id 查询 数据
     * @param id
     * @return
     */
    @Override
    public DiningStandard selectOneWithCompany(Integer id) {
        return diningStandardMapper.selectOneWithCompany(id);
    }

    /**
     * 根据价格和接受的价格波动查询在此价格区间的餐标和所属公司 15.5-2.5====13
     * @param price
     * @return
     */
    @Override
    public List<DiningStandard> selectByPrice(BigDecimal price, BigDecimal bodong) {
        return diningStandardMapper.selectByPrice(price,bodong);
    }

    /**
     * 根据 团餐公司编号 查询其设置的餐标
     * @param companyNo
     * @return
     */
    @Override
    public List<DiningStandard> selectAllByCompanyNo(Integer companyNo) {
        return diningStandardMapper.selectAllByCompanyNo(companyNo);
    }

    /**
     * 插入一条数据
     * @param diningStandard
     * @return
     */
    @Override
    public int InsertOne(DiningStandard diningStandard) {
        return diningStandardMapper.InsertOne(diningStandard);
    }

    /**
     * 更新数据
     * @param diningStandard
     * @return
     */
    @Override
    public int UpdateOne(DiningStandard diningStandard) {
        return diningStandardMapper.UpdateOne(diningStandard);
    }
}
