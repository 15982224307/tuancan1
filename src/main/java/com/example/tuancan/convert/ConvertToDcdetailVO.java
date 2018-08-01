package com.example.tuancan.convert;

import com.example.tuancan.dto.DeliverDetailVO;
import com.example.tuancan.model.DeliveringDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConvertToDcdetailVO {

    public static List<DeliverDetailVO> convertToDcdetailVO(List<DeliveringDetail> deliveringDetails){

        List<DeliverDetailVO> deliverDetailVOS=new ArrayList<DeliverDetailVO>();
        DeliverDetailVO detailVO=null;
        for (DeliveringDetail detail:deliveringDetails){
            detailVO=new DeliverDetailVO();
            detailVO.getRecipe().setRecipeId(detail.getRecipe().getRecipeId());
            detailVO.getRecipe().setRecipeName(detail.getRecipe().getRecipeName());
            detailVO.setDeliveringDetailNo(detail.getDeliveringDetailNo());
            detailVO.setDeliveringDetailNumber(detail.getDeliveringDetailNumber());
            detailVO.setDeliveringDetailMemo(detail.getDeliveringDetailMemo());
            deliverDetailVOS.add(detailVO);
        }

        return  deliverDetailVOS;
    }
}
