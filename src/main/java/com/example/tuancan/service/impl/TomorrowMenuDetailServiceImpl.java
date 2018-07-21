package com.example.tuancan.service.impl;

import com.example.tuancan.dao.TomorrowMenuDetailMapper;
import com.example.tuancan.model.TomorrowMenudetail;
import com.example.tuancan.service.TomorrowMenuDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TomorrowMenuDetailServiceImpl implements TomorrowMenuDetailService {

    @Autowired
    private TomorrowMenuDetailMapper tomorrowMenuDetailMapper;

    /**
     * 根据id 查询单个结果
     *
     * @param id
     */
    @Override
    public TomorrowMenudetail selectOneById(Integer id) {
        return tomorrowMenuDetailMapper.selectOneById(id);
    }

    /**
     * 根据用餐单位查询
     *
     * @param id
     */
    @Override
    public List<TomorrowMenudetail> selectByUnitId(Integer id) {
        return tomorrowMenuDetailMapper.selectByUnitId(id);
    }

    /**
     * 根据菜单编号查询
     *
     * @param id
     */
    @Override
    public List<TomorrowMenudetail> selectByMenuMasterId(Integer id) {
        return tomorrowMenuDetailMapper.selectByMenuMasterId(id);
    }

    /**
     * 是否推荐
     *
     * @param status
     */
    @Override
    public List<TomorrowMenudetail> selectByRecommend(int recommend) {
        return tomorrowMenuDetailMapper.selectByRecommend(recommend);
    }

    /**
     * 所有数据
     */
    @Override
    public List<TomorrowMenudetail> getAll() {
        return tomorrowMenuDetailMapper.getAll();
    }

    /**
     * 插入数据
     *
     * @param tomorrowMenudetail
     */
    @Override
    public int insertOne(TomorrowMenudetail tomorrowMenudetail) {
        return tomorrowMenuDetailMapper.insertOne(tomorrowMenudetail);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteOne(Integer id) {
        return tomorrowMenuDetailMapper.deleteOne(id);
    }

    /**
     * 更新数据
     *
     * @param tomorrowMenudetail
     */
    @Override
    public int updateOne(TomorrowMenudetail tomorrowMenudetail) {
        return tomorrowMenuDetailMapper.updateOne(tomorrowMenudetail);
    }
}
