package com.example.tuancan.controller;

import com.example.tuancan.utils.Constants;
import com.example.tuancan.dto.Scan;
import com.example.tuancan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @RequestMapping(value = "/wechat",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String index(HttpServletRequest request,@RequestBody Scan scan){
        Map<String, String[]> map = request.getParameterMap();
        log.info(JsonUtil.toJson(map));
        String signature=request.getParameter("signature");
        String echostr=request.getParameter("echostr");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        log.info(echostr);
        if (signature!=null&&echostr!=null&&!echostr.equals("")){
          //微信服务器验证
            log.info("======================");
            return  echostr;
        }

        //设置菜单
        WxMenu wxMenu = new WxMenu();
        List<WxMenuButton> wxMenuButtons = new ArrayList<WxMenuButton>();
        //一级菜单
        WxMenuButton button1 = new WxMenuButton();
        button1.setType("view");
        button1.setName("点餐");
        button1.setUrl("http://95ti4r.natappfree.cc/index");
        //一级菜单
        WxMenuButton button2 = new WxMenuButton();
        button2.setName("个人管理");
          //二级菜单
        List<WxMenuButton> subButtons = new ArrayList<WxMenuButton>();
        WxMenuButton subButton1 = new WxMenuButton();
        subButton1.setType("click");
        subButton1.setName("点击推送");
        subButton1.setKey("tuisong");

        WxMenuButton subButton2 = new WxMenuButton();
        subButton2.setType("scancode_waitmsg");
        subButton2.setName("扫码");
        subButton2.setKey("saoma");
        subButton2.setSubButtons(new ArrayList<>());
        //个人管理设置二级菜单
        subButtons.add(subButton1);
        subButtons.add(subButton2);
        button2.setSubButtons(subButtons);
        //添加一级菜单
        wxMenuButtons.add(button1);
        wxMenuButtons.add(button2);
        wxMenu.setButtons(wxMenuButtons);

        //往微信发送自定义菜单请求
        try {
            wxMpService.getMenuService().menuCreate(wxMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.info("error=====");
        }

        /*event参数：关注/取消关注事件 关注subscribe(订阅)、取消关注unsubscribe(取消订阅)
        扫描带参数二维码事件 关注subscribe, 已经关注SCAN，
        自定义菜单事件 点击菜单拉取消息时的事件推送 CLICK 点击菜单跳转链接时的事件推送 VIEW
        上报地理位置事件 LOCATION*/

        //用户关注事件推送
        if (scan.getEvent().equals(Constants.WhChat.EVENT_SUBSCRIBE)){

            //有ticket 说明是用户扫描二维码进行关注
            if ( StringUtils.isNotEmpty(scan.getTicket())){

                log.info("有ticket 说明是用户扫描二维码进行关注");
                log.info(JsonUtil.toJson(scan));

            }else {

                //无ticket 说明是用户其他方式进行关注公众号
                log.info("无ticket 说明是用户其他方式进行关注公众号");
                log.info(JsonUtil.toJson(scan));
            }
        }else if(scan.getEvent().equals(Constants.WhChat.EVENT_UNSUBSCRIBE)){
            //用户取消关注事件
            log.info("用户取消关注事件 unsubscribe");
            log.info(JsonUtil.toJson(scan));

        }else  if (scan.getEvent().equals(Constants.WhChat.EVENT_SCAN)){
            //用户扫描二维码 但已经关注 进公众号推送事件

            log.info("用户扫描二维码 但已经关注 进公众号推送事件 Scan");
            log.info(JsonUtil.toJson(scan));

        }else  if(scan.getEvent().equals(Constants.WhChat.EVENT_CLICK)){
            //点击菜单拉取消息时的事件推送

            log.info("点击菜单拉取消息时的事件推送 CLICK");
            log.info(JsonUtil.toJson(scan));
            WxMpKefuMessage message = WxMpKefuMessage.TEXT().toUser(scan.getFromUserName()).content("你是傻逼").build();
            try {
                wxMpService.getKefuService().sendKefuMessage(message);
            } catch (WxErrorException e) {
                e.printStackTrace();
            }

        } else if (scan.getEvent().equals(Constants.WhChat.EVENT_VIEW)){
            //点击菜单跳转链接时的事件推送
            log.info("点击菜单跳转链接时的事件推送view");
            log.info(JsonUtil.toJson(scan));

        } else if (scan.getEvent().equals(Constants.WhChat.EVENT_LOCATION)){
            //点上报地理位置事件 LOCATION
            log.info("点上报地理位置事件 ");
            log.info(JsonUtil.toJson(scan));

        } else {

            log.info("其他");
            log.info(JsonUtil.toJson(scan));
        }
        return "";
    }
}
