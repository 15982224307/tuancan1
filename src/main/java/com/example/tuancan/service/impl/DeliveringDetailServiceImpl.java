package com.example.tuancan.service.impl;

import com.example.tuancan.dao.DeliveringDetailMapper;
import com.example.tuancan.model.DeliveringDetail;
import com.example.tuancan.service.DeliveringDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeliveringDetailServiceImpl implements DeliveringDetailService {

    @Autowired
    private DeliveringDetailMapper deliveringDetailMapper;

    /**
     * 根据配送明细序号查询
     * @return
     */
    @Override
    public DeliveringDetail selectByDeliveringDetailNo(Integer deliveringDetailNo) {
        return deliveringDetailMapper.selectByDeliveringDetailNo(deliveringDetailNo);
    }

    /**
     * 根据配送单id查询 其该包含的所有配送明细信息
     * @param deliveringMasterId
     * @return
     */
    @Override
    public List<DeliveringDetail> selectByDeliveringMasterId(Integer deliveringMasterId) {
        return deliveringDetailMapper.selectByDeliveringMasterId(deliveringMasterId);
    }

    /**
     * 根据食谱id查询 使用该食谱的所有配送明细信息
     * @param recipeId
     * @return
     */
    @Override
    public List<DeliveringDetail> selectByrecipeId(Integer recipeId) {
        return deliveringDetailMapper.selectByrecipeId(recipeId);
    }

    /**
     * 插入数据
     * @param deliveringDetail
     * @return
     */
    @Override
    @Transactional
    public int InsertOne(DeliveringDetail deliveringDetail) {
        return deliveringDetailMapper.InsertOne(deliveringDetail);
    }

    /**
     * 更新数据
     * @param deliveringDetail
     * @return
     */
    @Override
    @Transactional
    public int updateOne(DeliveringDetail deliveringDetail) {
        return deliveringDetailMapper.updateOne(deliveringDetail);
    }
}
