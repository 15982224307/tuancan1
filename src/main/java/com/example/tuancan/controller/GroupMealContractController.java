package com.example.tuancan.controller;

import com.example.tuancan.enums.StatusEnum;
import com.example.tuancan.model.DeliveringCompany;
import com.example.tuancan.model.DiningStandard;
import com.example.tuancan.model.GroupMealContract;
import com.example.tuancan.service.DeliveringCompanyService;
import com.example.tuancan.service.DiningStandardService;
import com.example.tuancan.service.GroupMealContractService;
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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Author xiaoqy
 * @Date 2018/8/3
 * @Description 合同
 */
@Controller
@Slf4j
@RequestMapping("groupMealContract")
public class GroupMealContractController {

    @Autowired
    private GroupMealContractService groupMealContractService;

    @Autowired
    private DeliveringCompanyService deliveringCompanyService;

    @Autowired
    private DiningStandardService diningStandardService;

    @RequestMapping(value = {"/yes_list/{pagenum}","/yes_list"})
    public String dcStausYeslist(Model model,@PathVariable(value = "pagenum",required = false) Integer pageNum){
        if (pageNum==null||pageNum<=0){
            pageNum=1;
        }
        Page<Object> page = PageHelper.startPage(pageNum, 5);
        List<DeliveringCompany> deliveringCompanies = deliveringCompanyService.selectAllByStatus(StatusEnum.StatusUP.getCode());
        PageInfo<DeliveringCompany> pageInfo = new PageInfo<DeliveringCompany>(deliveringCompanies);
        PageUtil.setPageModel(model,pageInfo,"/groupMealContract/yes_list");

        return "/unitmealmanager/contract_details::#searchtable";
    }

    @RequestMapping(value = "/getdining",method = {RequestMethod.POST})
    @ResponseBody
    public List<DiningStandard> getDiner(@RequestParam(value = "dcno")Integer dcno){

        List<DiningStandard> diningStandards = diningStandardService.selectAllByCompanyNo(dcno);

        return diningStandards;
    }

    @RequestMapping(value = "/show",method = {RequestMethod.GET})
    public String showContract(Model model, HttpServletRequest request){
         /*获取登录的用餐公司id*/
        String unitIDstr = (String) request.getSession().getAttribute("unitID");
        if (StringUtils.isEmpty(unitIDstr)||unitIDstr==""){
            return "redirect:/login";
        }
        log.info("unitID>>>session>>"+unitIDstr);
        Integer unitID=Integer.parseInt(unitIDstr);
        List<GroupMealContract> groupMealContracts = groupMealContractService.selectOneByUnitId(unitID);
        if (CollectionUtils.isEmpty(groupMealContracts)){
            //以前未签订合同
            String s = dcStausYeslist(model, 1);

            return "/unitmealmanager/contract_details";

        }else {
            //有合同 直接展示合同页面
            Date expirydate = groupMealContracts.get(0).getGMlContractExpirydate();
            Date date = new Date();
            log.info("expirydate"+expirydate.getTime()+">>>"+date.getTime());
            if(expirydate.getTime()<date.getTime()){
                //合同在有效期内

            }else {
                //合同过期

            }
        }
        return "";
    }

    @RequestMapping(value = "/save",method = {RequestMethod.POST})
    @ResponseBody
    public String  setContract(GroupMealContract groupMealContract,@RequestParam(value = "monthoryear")Integer monthoryear,
                               @RequestParam(value = "datenum")Integer datenum){

        log.info(JsonUtil.toJson(groupMealContract));
        log.info(datenum+">>"+monthoryear);
        return "ok";
    }
}
