package com.example.tuancan.controller;

import com.example.tuancan.dto.Result;
import com.example.tuancan.dto.TreeVO;
import com.example.tuancan.enums.ResultEnum;
import com.example.tuancan.model.Classification;
import com.example.tuancan.model.FoodMaterial;
import com.example.tuancan.model.MainCategorie;
import com.example.tuancan.service.ClassificationService;
import com.example.tuancan.service.FoodMaterialService;
import com.example.tuancan.service.MainCategorieService;
import com.example.tuancan.utils.JsonUtil;
import com.example.tuancan.utils.PageUtil;
import com.example.tuancan.utils.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/foodMaterial")
public class FoodMaterialController {

    private String path="D:\\tuancan";
    @Autowired
    private FoodMaterialService foodMaterialService;

    @Autowired
    private MainCategorieService mainCategorieService;

    @Autowired
    private ClassificationService classificationService;

    @RequestMapping(value = {"/list/{pagenum}","/list"})
    public String  rtlist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<FoodMaterial> foodMaterials = foodMaterialService.getAll();
        PageInfo<FoodMaterial> pageInfo = new PageInfo<FoodMaterial>(foodMaterials);

        log.info(pageInfo.getPages()+"xx"+pageInfo.getNextPage()+"xx"+
                pageInfo.isIsFirstPage()+pageInfo.isHasPreviousPage());
        log.info(JsonUtil.toJson(page.getResult()));
        PageUtil.setPageModel(model,pageInfo,"/foodMaterial/list");

        return "/manager/foodma_list";
    }

    @RequestMapping(value = "/getone/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public FoodMaterial getOne(@PathVariable(value = "id")Integer id){
        return foodMaterialService.selectOneById(id);
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String  saveorupdate(Model model,FoodMaterial  foodMaterial){
        log.info(JsonUtil.toJson(foodMaterial));
        if (foodMaterial.getFoodmaterialId()!=null){
            //更新
            int updateOne = foodMaterialService.updateOne(foodMaterial);
            log.info(updateOne+"updateOne");
        }else {
            //新增
            int insertOne = foodMaterialService.insertOne(foodMaterial);
            log.info(insertOne+"insertOne");
        }
        return "ok";
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.POST})
    @ResponseBody
    public String  delete(Model model,@PathVariable("id") Integer id){
        log.info(id+"");
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
        Page<Object> page = PageHelper.startPage(pageNum, 10);
        List<FoodMaterial> foodMaterials = foodMaterialService.selectByName(decode);
        PageInfo<FoodMaterial> pageInfo = new PageInfo<FoodMaterial>(foodMaterials);
        log.info(JsonUtil.toJson(foodMaterials));
        PageUtil.setPageModel(model,pageInfo,"/foodMaterial/search/"+encode);

        if (!asyc){
            return "/manager/foodma_list";
        }
        return "/manager/foodma_list :: #searchtable";
    }

    @RequestMapping(value = "/getTree")
    @ResponseBody
    public  List<TreeVO> getTree(@RequestParam(value = "id",required = false) Integer id,
                                 @RequestParam(value = "name",required = false)String name){
        log.info(id+"="+name);
        List<TreeVO> treeVOS=new ArrayList<>();
        TreeVO treeVO=null;
        if (id==null||StringUtils.isEmpty(name)){
            treeVO = new TreeVO();
            treeVO.setId("0");
            treeVO.setName("请选择分类");
            treeVOS.add(treeVO);
            List<MainCategorie> mainCategories = mainCategorieService.getAll();
            for (MainCategorie m:mainCategories){
                treeVO = new TreeVO();
                treeVO.setId(String.valueOf(m.getMaincategorieId()));
                treeVO.setName(m.getMaincategorieName());
                treeVO.setpId("0");
                treeVOS.add(treeVO);
            }
        }else {
            List<Classification> classifications = classificationService.selectByMainId(id);
            for (Classification c:classifications){
                treeVO = new TreeVO();
                treeVO.setId(String.valueOf(c.getClassificationId()));
                treeVO.setName(c.getClassificationName());
                treeVO.setpId(String.valueOf(id));
                treeVO.setIsParent("false");
                treeVOS.add(treeVO);
            }

        }
        return treeVOS;
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam(value = "fmid")Integer fmid,
                         @RequestParam(value = "picfile")MultipartFile picfile){
        if (!picfile.isEmpty()){
            log.info(picfile.getOriginalFilename()+"==========>文件开始上传");
            String ext=picfile.getOriginalFilename()
                    .substring(picfile.getOriginalFilename().lastIndexOf(".")-1).toLowerCase();
            String filename="pic"+System.currentTimeMillis()+ext;
            log.info("=======>存储名称"+filename);
            try {
               // path= ResourceUtils.getURL("classpath:").getPath();
                log.info(""+path);
                File destfile = new File(path +"/"+filename);
                if (!destfile.getParentFile().exists()){
                    destfile.getParentFile().mkdirs();
                }

                picfile.transferTo(destfile);
                log.info(destfile.getAbsolutePath()+">>"+destfile.getPath());
                int updatePic = foodMaterialService.updatePic(fmid, destfile.getAbsolutePath());
                log.info("updatePic"+updatePic);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResultUtil.status(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage());
        }
        return ResultUtil.status(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMessage());

    }
}
