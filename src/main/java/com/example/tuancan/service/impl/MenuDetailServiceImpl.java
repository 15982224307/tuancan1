package com.example.tuancan.service.impl;

import com.example.tuancan.dao.MenuDetailMapper;
import com.example.tuancan.model.MenuDetail;
import com.example.tuancan.service.MenuDetailService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDetailServiceImpl implements MenuDetailService {

    @Autowired
    private MenuDetailMapper menuDetailMapper;

    /**
     * 菜单编号查询
     *
     * @param no
     */
    @Override
    public List<MenuDetail> selectByMasterNo(Integer no) {
        return menuDetailMapper.selectByMasterNo(no);
    }

    /**
     * 食谱编号查询
     *
     * @param no
     */
    @Override
    public List<MenuDetail> selectByRecipeNo(Integer no) {
        return menuDetailMapper.selectByRecipeNo(no);
    }

    /*菜单和食谱对应查询*/
    @Override
    public MenuDetail selectByRecipeNoAndMasterNo(Integer m_no, Integer r_no) {
         return menuDetailMapper.selectByRecipeNoAndMasterNo(m_no,r_no);
    }

    /**
     * 菜单序号号查询
     *
     * @param no
     */
    @Override
    public List<MenuDetail> selectByDetailId(Integer no) {
        return menuDetailMapper.selectByDetailId(no);
    }




    /**
     * 插入数据
     *
     * @param menuDetail
     */
    @Override
    public int insertOne(MenuDetail menuDetail) {
        return menuDetailMapper.insertOne(menuDetail);
    }

    /**
     * 更新数据
     *
     * @param menuDetail
     */
    @Override
    public int updateOne(MenuDetail menuDetail) {
        return menuDetailMapper.updateOne(menuDetail);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    @Override
    public int deleteOne(Integer id) {
        return menuDetailMapper.deleteOne(id);
    }
}
