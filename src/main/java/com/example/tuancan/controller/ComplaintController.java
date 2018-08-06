package com.example.tuancan.controller;

import com.example.tuancan.model.Complaint;
import com.example.tuancan.service.ComplaintService;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author xiao
 */
@Controller
@Slf4j
@RequestMapping("/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = {"/yes_list/{pagenum}","/yes_list"})
    public String  yeslist(Model model, @PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 9);
        List<Complaint> complaints = complaintService.selectAll();
        PageInfo<Complaint> pageInfo = new PageInfo<Complaint>(complaints);

        log.info(pageInfo.getPages()+"xx"+pageInfo.getNextPage()+"xx"+
                pageInfo.isIsFirstPage()+pageInfo.isHasPreviousPage());
        log.info(JsonUtil.toJson(page.getResult()));
        PageUtil.setPageModel(model,pageInfo,"/complaint/yes_list");

        return "/manager/cp_list";
    }
    @RequestMapping(value = {"/no_list/{pagenum}","/no_list"})
    public String Nolist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 9);
        List<Complaint> complaints = complaintService.selectNULL();
        PageInfo<Complaint> pageInfo = new PageInfo<Complaint>(complaints);

        log.info(JsonUtil.toJson(page.getResult()));
        PageUtil.setPageModel(model,pageInfo,"/complaint/no_list");

        return "/manager/cp_list";
    }


    @RequestMapping(value = "/cp_details/{id}",method = {RequestMethod.GET})
    public String getOne(@PathVariable(value = "id")Integer id,Model model){
        log.info(id+">>>>cpdetails");
        Complaint complaint = complaintService.selectById(id);
        model.addAttribute("cp",complaint);
        return "/manager/cp_update";
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String  saveorupdate(Model model,Complaint  complaint){
        log.info(JsonUtil.toJson(complaint));
        if (complaint.getComplaintId()!=null){
            //更新
            int updateOne = complaintService.updateOne(complaint);
            log.info(updateOne+"updateOne");
        }else {

        }
        return "ok";
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public String  delete(Model model,@PathVariable("id") Integer id){
        int i = complaintService.deleteOne(id);
        log.info(id+">>delete"+i);
        return "ok";
    }

    @RequestMapping(value = {"/search/{name}","/search/{name}/{pagenum}"},method = {RequestMethod.POST,RequestMethod.GET})
    public String  search(Model model,@PathVariable(value = "name",required = false) String name,
                          @PathVariable(value = "pagenum",required = false) Integer pageNum,
                          @RequestParam(value = "asyc",required = false,defaultValue ="false")Boolean asyc){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if (StringUtils.isEmpty(name)||name.equals("*")){
            name="";
        }
        log.info(name);
        String decode=null;
        String encode=null;
        try {
            //先解码 在编码
            decode= URLDecoder.decode(name, "utf-8");
            decode= URLDecoder.decode(decode, "utf-8");
            encode = URLEncoder.encode(decode,"utf-8");
            encode = URLEncoder.encode(encode,"utf-8");
            log.info(encode+"++"+decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Page<Object> page = PageHelper.startPage(pageNum, 9);
        List<Complaint> complaints = complaintService.selectAllBByComplaintSettleOrderBySettleDate(decode);
        PageInfo<Complaint> pageInfo = new PageInfo<Complaint>(complaints);
        log.info(JsonUtil.toJson(complaints));
        PageUtil.setPageModel(model,pageInfo,"/complaint/search/"+encode);

        if (!asyc){
            return "/manager/cp_list";
        }
        return "/manager/cp_list :: #searchtable";
    }

}
