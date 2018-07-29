package com.example.tuancan.controller;

import com.example.tuancan.model.RecipeType;
import com.example.tuancan.service.RecipeTypeService;
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
@RequestMapping("recipeType")
public class RecipeTypeController {

    @Autowired
    private RecipeTypeService recipeTypeService;

    @RequestMapping(value = {"/list/{pagenum}","/list"})
    public String  rtlist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<RecipeType> recipeTypes = recipeTypeService.selectOrderByCreateDateDESC();
        PageInfo<RecipeType> pageInfo = new PageInfo<RecipeType>(recipeTypes);

        PageUtil.setPageModel(model,pageInfo,"/recipeType/list");

        return "/manager/rctype_list";
    }
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String  saveorupdate(Model model,RecipeType  recipeType){
        log.info(JsonUtil.toJson(recipeType));
        if (recipeType.getRecipeTypeId()!=null){
            //更新
            log.info("更新"+recipeType.getRecipeTypeId()+"");
            int updateOne = recipeTypeService.updateOne(recipeType);
            log.info(updateOne+"");
        }else {
            //新增
            int insertOne = recipeTypeService.insertOne(recipeType);
            log.info(insertOne+"");
        }

        return "ok";
    }
    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public String  delete(Model model,@PathVariable("id") Integer id){
        log.info(id+"");
        int i = recipeTypeService.deleteOne(id);
        log.info("删除"+i);

        return "ok";
    }

    @RequestMapping(value = {"/search/{name}","/search/{name}/{pagenum}"},method = {RequestMethod.POST,RequestMethod.GET})
    public String  search(Model model,@PathVariable(value = "name",required = false) String name,
                          @PathVariable(value = "pagenum",required = false) Integer pageNum,
                          @RequestParam(value = "asyc",required = false,defaultValue ="false")Boolean asyc){

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
        log.info(pageNum+"");
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<RecipeType> recipeTypes = recipeTypeService.selectByName(name);
        PageInfo<RecipeType> pageInfo = new PageInfo<RecipeType>(recipeTypes);
        log.info(JsonUtil.toJson(recipeTypes));

        PageUtil.setPageModel(model,pageInfo,"/recipeType/search/"+encode);

        model.addAttribute("typelist",recipeTypes);

        if (!asyc){
            return "/manager/rctype_list";
        }
        return "/manager/rctype_list :: #searchtable";
    }
}
