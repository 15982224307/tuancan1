package com.example.tuancan.service.impl;

import com.example.tuancan.dao.GtodMessageMapper;
import com.example.tuancan.model.GtodMessage;
import com.example.tuancan.service.GtodMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GtodMessageServiceImpl implements GtodMessageService {

    @Autowired
    private GtodMessageMapper gtodMessageMapper;

    /**
     * 根据id查询
     *
     * @param id
     */
    @Override
    public GtodMessage selectById(Integer id) {
        return gtodMessageMapper.selectByPrimaryKey(id);
    }

    /**
     * 状态查询
     *
     * @param status
     */
    @Override
    public List<GtodMessage> selectByStatus(Integer status) {
        return gtodMessageMapper.selectByStatus(status);
    }

    /**
     * 团餐机构消息查询
     *
     * @param id
     */
    @Override
    public List<GtodMessage> selectByUnitId(Integer id) {
        return gtodMessageMapper.selectByUnitId(id);
    }

    /**
     * 查看某个机构的当前时间的未读消息
     *
     * @param id
     */
    @Override
    public List<GtodMessage> selectNoReadByUnitId(Integer id) {
        return gtodMessageMapper.selectNoReadByUnitId(id);
    }

    /**
     * 所有数据
     *
     * @param id
     */
    @Override
    public List<GtodMessage> getAll(Integer id) {
        return gtodMessageMapper.selectAll();
    }

    /**
     * 特定时间清除消息
     */
    @Override
    public int deleteReaded() {
        return gtodMessageMapper.deleteReaded();
    }

    /**
     * 更新消息
     *
     * @param id
     */
    @Override
    public int updateStatusById(Integer id) {
        return gtodMessageMapper.updateStatusById(id);
    }

    /**
     * 插入消息
     *
     * @param gtodMessage
     */
    @Override
    public int insertOne(GtodMessage gtodMessage) {
        return gtodMessageMapper.insertOne(gtodMessage);
    }

}
