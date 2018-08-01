package com.example.tuancan.controller;

import com.example.tuancan.convert.ConvertToDcdetailVO;
import com.example.tuancan.dto.DeliverDetailVO;
import com.example.tuancan.model.DeliveringDetail;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.service.DeliveringDetailService;
import com.example.tuancan.service.DeliveringMasterService;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("deliveringMaster")
public class DeliveringMasterController {

    @Autowired
    private DeliveringMasterService deliveringMasterService;

    @Autowired
    private DeliveringDetailService detailService;

    @RequestMapping(value = {"/list/{pagenum}","/list"})
    public String  rtlist(Model model, @PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectAllWithDeliverComAndMealUnit();
        PageInfo<DeliveringMaster> pageInfo = new PageInfo<DeliveringMaster>(deliveringMasters);

        log.info(pageInfo.getPages()+"xx"+pageInfo.getNextPage()+"xx"+
                pageInfo.isIsFirstPage()+pageInfo.isHasPreviousPage());
        log.info(JsonUtil.toJson(page.getResult()));
        PageUtil.setPageModel(model,pageInfo,"/deliveringMaster/list");

        return "/manager/dm_list";
    }

    @RequestMapping(value = "/dm_details/{id}",method = {RequestMethod.GET})
    public String getOne(@PathVariable(value = "id")Integer id,Model model){
        log.info(id+">>>>dmdetails");

        DeliveringMaster deliveringMaster = deliveringMasterService.selectOneById(id);
        List<DeliveringDetail> deliveringDetails = detailService.selectByDeliveringMasterId(id);
        List<DeliverDetailVO> deliverDetailVOS = ConvertToDcdetailVO.convertToDcdetailVO(deliveringDetails);

        log.info(JsonUtil.toJson(deliverDetailVOS));
        model.addAttribute("details",deliverDetailVOS);
        model.addAttribute("dm",deliveringMaster);
        return "/manager/dm_update";
    }
}
