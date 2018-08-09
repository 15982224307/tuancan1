package com.example.tuancan.controller;

import com.example.tuancan.convert.ConvertToDcdetailVO;
import com.example.tuancan.dto.DeliverDetailVO;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DeliveringDetail;
import com.example.tuancan.model.DeliveringMaster;
import com.example.tuancan.model.GroupMealUnit;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.service.DeliveringDetailService;
import com.example.tuancan.service.DeliveringMasterService;
import com.example.tuancan.service.GroupMealUnitService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 *
 * @author xiao
 */
@Slf4j
@Controller
@RequestMapping("deliveringMaster")
public class DeliveringMasterController {

    @Autowired
    private DeliveringMasterService deliveringMasterService;

    @Autowired
    private DeliveringDetailService detailService;

    @Autowired
    private GroupMealUnitService groupMealUnitService;

    @Autowired
    private DeliveringCompanyService deliveringCompanyService;

    public void pageFun(Model model,List<DeliveringMaster> deliveringMasters,String path){
        PageInfo<DeliveringMaster> pageInfo = new PageInfo<DeliveringMaster>(deliveringMasters);

        log.info(pageInfo.getPages()+"xx"+pageInfo.getNextPage()+"xx"+
                pageInfo.isIsFirstPage()+pageInfo.isHasPreviousPage());
        log.info(JsonUtil.toJson(pageInfo.getList()));
        PageUtil.setPageModel(model,pageInfo,path);
    }
    /*平台查看所有配送情况*/
    @RequestMapping(value = {"/list/{pagenum}","/list"})
    public String  rtlist(Model model, @PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectAllWithDeliverComAndMealUnit();
        pageFun(model,deliveringMasters,"/deliveringMaster/list");

        return "/manager/dm_list";
    }

    public void detailFun(Integer id,Model model){
        log.info(id+">>>>dmdetails");

        DeliveringMaster deliveringMaster = deliveringMasterService.selectOneById(id);
        List<DeliveringDetail> deliveringDetails = detailService.selectByDeliveringMasterId(id);
        List<DeliverDetailVO> deliverDetailVOS = ConvertToDcdetailVO.convertToDcdetailVO(deliveringDetails);

        log.info(JsonUtil.toJson(deliverDetailVOS));
        model.addAttribute("details",deliverDetailVOS);
        model.addAttribute("dm",deliveringMaster);
    }
    /*平台查看配送情况细节*/
    @RequestMapping(value = "/dm_details/{id}",method = {RequestMethod.GET})
    public String getOne(@PathVariable(value = "id")Integer id,Model model){
        detailFun(id,model);
        return "/manager/dm_update";
    }

    /*用餐单位查看配送情况细节*/
    @RequestMapping(value = "/dm_unit_details/{id}",method = {RequestMethod.GET})
    public String getUnitdm(@PathVariable(value = "id")Integer id,Model model){
        detailFun(id,model);
        return "/unitmealmanager/dm_unit_update";
    }

    /*用餐单位查看配送情况*/
    @RequestMapping(value = {"/unitlist/{pagenum}","/unitlist"})
    public String unitDelivermaster(HttpServletRequest request,Model model, @PathVariable(value = "pagenum",required = false) Integer pageNum){
        /*获取登录的用餐公司id*/
        String unitIDstr = (String) request.getSession().getAttribute("unitID");
        log.info("unitID>>>session>>"+unitIDstr);
        Integer unitID=Integer.parseInt(unitIDstr);
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);

        List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectByUnitId(unitID);
        pageFun(model,deliveringMasters,"/deliveringMaster/unitlist");

        GroupMealUnit groupMealUnit = groupMealUnitService.selectOneById(unitID);
        model.addAttribute("unitVO",groupMealUnit);

        return "/unitmealmanager/dm_unit_list";
    }


    /*团餐餐单位查看配送情况*/
    @RequestMapping(value = {"/deliverlist/{pagenum}","/deliverlist"})
    public String deliverDelivermaster(HttpServletRequest request,Model model, @PathVariable(value = "pagenum",required = false) Integer pageNum){
        /*获取登录的团餐餐公司id*/
        String dcnoStr = (String) request.getSession().getAttribute("dcno");
        log.info("dcno>>>session>>"+dcnoStr);
        Integer dcno=Integer.parseInt(dcnoStr);
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);

        List<DeliveringMaster> deliveringMasters = deliveringMasterService.selectBydcNo(dcno);
        pageFun(model,deliveringMasters,"/deliveringMaster/deliverlist");

        DeliveringCompany deliveringCompany = deliveringCompanyService.selectByIdWithGrade(dcno);
        model.addAttribute("dc",deliveringCompany);
        return "/unitmealmanager/dm_deliver_list";
    }
}
