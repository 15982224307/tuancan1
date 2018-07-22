package com.example.tuancan.service.impl;

import com.example.tuancan.dao.CompanyGradeMapper;
import com.example.tuancan.model.CompanyGrade;
import com.example.tuancan.service.CompanyGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyGradeServiceImpl implements CompanyGradeService {

    @Autowired
    private CompanyGradeMapper companyGradeMapper;

    /**
     * 根据id删除一个等级
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int deleteById(Integer id) {
        return companyGradeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 插入一条数据
     * @param companyGrade
     * @return
     */
    @Override
    @Transactional
    public int insert(CompanyGrade companyGrade) {
        return companyGradeMapper.insert(companyGrade);
    }

    @Override
    public int updataOne(CompanyGrade companyGrade) {
        return companyGradeMapper.updateByPrimaryKey(companyGrade);
    }

    /**
     * 查询一条数据
     * @param id
     * @return
     */
    @Override
    public CompanyGrade selectById(Integer id) {
        return companyGradeMapper.selectByPrimaryKey(id);
    }
    /**
     * 查询多条数据
     * @return
     */
    @Override
    public List<CompanyGrade> selectAll() {
        return companyGradeMapper.selectAll();
    }
}
