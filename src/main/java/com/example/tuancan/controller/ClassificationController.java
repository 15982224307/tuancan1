package com.example.tuancan.controller;

import com.example.tuancan.model.Classification;
import com.example.tuancan.service.ClassificationService;
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

@Controller
@Slf4j
@RequestMapping("classification")
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @RequestMapping(value = {"/list/{pagenum}","/list"})
    public String  rtlist(Model model, @PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<Classification> classifications = classificationService.getAll();
        PageInfo<Classification> pageInfo = new PageInfo<Classification>(classifications);

        log.info(pageInfo.getPages()+"xx"+pageInfo.getNextPage()+"xx"+
                pageInfo.isIsFirstPage()+pageInfo.isHasPreviousPage());
        log.info(JsonUtil.toJson(page.getResult()));
        PageUtil.setPageModel(model,pageInfo,"/classification/list");

        return "/manager/cf_list";
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String save(Classification classification){
        if (classification.getClassificationId()==null){
            int insertOne =classificationService.insertOne(classification);
            log.info("insertOne"+insertOne);
        }else {
            int updateOne = classificationService.updateOne(classification);
            log.info("updateOne"+updateOne);
        }
        return "ok";
    }

    @RequestMapping(value = {"/search/{name}","/search/{name}/{pagenum}"},method = {RequestMethod.POST,RequestMethod.GET})
    public String search(Model model, @PathVariable(value = "name",required = false) String name,
                         @PathVariable(value = "pagenum",required = false) Integer pageNum,
                         @RequestParam(value = "asyc",required = false,defaultValue = "false")Boolean asyc){

        log.info(name+"+"+asyc);
        //PageUtil.checkPageNumAndCriteria(pageNum,name);
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if (StringUtils.isEmpty(name)||name.equals("*")){
            name="";
        }
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
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<Classification> classifications = classificationService.selectByName(decode);
        PageInfo<Classification> pageInfo = new PageInfo<Classification>(classifications);
        log.info(JsonUtil.toJson(classifications));

        PageUtil.setPageModel(model,pageInfo,"/classification/search/"+encode);
        if (!asyc){
            return "/manager/cf_list";
        }
        return "/manager/cf_list :: #searchtable";
    }
}
