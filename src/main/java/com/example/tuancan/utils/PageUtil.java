package com.example.tuancan.utils;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;

public class PageUtil {

    /**
     *
     * @param pageNum 分页当前页数
     * @param criteria 当前搜索的关键字 判断
     */
    public static void checkPageNumAndCriteria(Integer pageNum,String criteria){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        if (StringUtils.isEmpty(criteria)||criteria.equals("*")){
            criteria="";
        }
    }
    /**
     *
     * @param model
     * @param pageInfo 分页属性
     * @param pagepath 分页访问路径
     */
    public static void setPageModel(Model model,PageInfo pageInfo,String pagepath){
        //获得当前页
        model.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        //分页访问路径路径
        model.addAttribute("path",pagepath);
        //  结果集
        model.addAttribute("page",pageInfo);

    }
}
