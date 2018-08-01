package com.example.tuancan.service.impl;

import com.example.tuancan.dao.DeliveringCompanyMapper;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.service.DeliveringCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class DeliveringCompanyServiceImpl implements DeliveringCompanyService {

    @Autowired
    private DeliveringCompanyMapper deliveringCompanyMapper;

    /**
     * 插入一条数据 并且把等级外键插入
     * @param deliveringCompany
     * @return
     */
    @Override
    @Transactional
    public int insertOne(DeliveringCompany deliveringCompany) {

        return deliveringCompanyMapper.insertOne(deliveringCompany);
    }

    /**
     * 更新团餐机构的数据 或者等级
     * @param deliveringCompany
     * @return
     */
    @Override
    @Transactional
    public int updateOne(DeliveringCompany deliveringCompany) {
        return deliveringCompanyMapper.updateOne(deliveringCompany);
    }

    /**
     * 查询一个团餐机构的数据 并且伴随其等级
     * @return
     */
    @Override
    public DeliveringCompany selectByIdWithGrade(Integer deliveringCompany) {
        return deliveringCompanyMapper.selectByIdWithGrade(deliveringCompany);
    }

    /**
     * cha询所有团餐机构的数据 并且伴随其等级
     * @return
     */
    @Override
    public List<DeliveringCompany> selectAllWithGrade() {
        return deliveringCompanyMapper.selectAllWithGrade();
    }

    @Override
    public List<DeliveringCompany> selectAllByName(String name) {
        return deliveringCompanyMapper.selectAllByName(name);
    }

    @Override
    public List<DeliveringCompany> selectAllByStatus(Integer status) {
        return deliveringCompanyMapper.selectAllByStatus(status);
    }

    @Override
    public List<DeliveringCompany> findByExample(Example example) {
        return deliveringCompanyMapper.selectByExample(example);
    }

    @Override
    public int updateStatusById(Integer id, Integer status) {
        return deliveringCompanyMapper.updateStatusById(id,status);
    }
}
