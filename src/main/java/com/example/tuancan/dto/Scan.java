package com.example.tuancan.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scan {
    private Integer id;

    /*开发者微信号*/
    @XmlElement(name="ToUserName",required = false)
    private String toUserName;

    /*发送方帐号（一个OpenID）*/
    @XmlElement(name="FromUserName",required = false)
    private String fromUserName;

    @XmlElement(name="CreateTime",required = false)
    private Integer createTime;

    /*消息类型，event */
    @XmlElement(name="MsgType",required = false)
    private String msgType;

    /* 事件类型
    关注/取消关注事件 关注subscribe(订阅)、取消关注unsubscribe(取消订阅)
    扫描带参数二维码事件 关注subscribe, 已经关注SCAN，
    自定义菜单事件 CLICK
    上报地理位置事件 LOCATION*/
    @XmlElement(name="Event",required = false)
    private String event;

    /*
    上报地理位置事件 无
    自定义菜单事件 事件KEY值，与自定义菜单接口中KEY值对应
    点击菜单跳转链接时的事件推送 VIEW*/
    @XmlElement(name="EventKey",required = false)
    private String eventKey;

    /*二维码的ticket 用户关注或未关注 扫描二维码进公众号会发送*/
    @XmlElement(name="Ticket",required = false)
    private String ticket;

    /*地理位置纬度*/
    @XmlElement(name="Latitude",required = false)
    private String latitude;

    /*地理位置经度*/
    @XmlElement(name="Longitude",required = false)
    private String longitude;

    /*地理位置精度*/
    @XmlElement(name="Precision",required = false)
    private String precision;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}