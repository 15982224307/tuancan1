package com.example.tuancan.service.impl;

import com.example.tuancan.dao.GroupMealMenumasterMapper;
import com.example.tuancan.model.GroupMealMenumaster;
import com.example.tuancan.service.GroupMealMenumasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GroupMealMenumasterServiceImpl implements GroupMealMenumasterService {

    @Autowired
    private GroupMealMenumasterMapper groupMealMenuMasterMapper;

    /**
     * 根据id 查询
     */
    @Override
    public GroupMealMenumaster selectOneById(Integer id) {
        return groupMealMenuMasterMapper.selectOneById(id);
    }

    /**
     * 根据菜单名称模糊查询
     * @param name
     * @return
     */
    @Override
    public List<GroupMealMenumaster> selectByName(String name) {
        return groupMealMenuMasterMapper.selectByName(name);
    }

    /**
     *  查询所有
     */
    @Override
    public List<GroupMealMenumaster> selectAllWithUnit() {
        return groupMealMenuMasterMapper.selectAllWithUnit();
    }
    /**
     * 更新数据
     * @param groupMealMenumaster
     * @return
     */
    @Override
    @Transactional
    public int UpdateOne(GroupMealMenumaster groupMealMenumaster) {
        return groupMealMenuMasterMapper.UpdateOne(groupMealMenumaster);
    }

    /**
     * 插入数据
     * @param groupMealMenumaster
     * @return
     */
    @Override
    @Transactional
    public int InsertOne(GroupMealMenumaster groupMealMenumaster) {
        return groupMealMenuMasterMapper.InsertOne(groupMealMenumaster);
    }
}
