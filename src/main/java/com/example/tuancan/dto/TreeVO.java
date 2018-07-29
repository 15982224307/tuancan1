package com.example.tuancan.dto;

public class TreeVO {
  private String id;//节点id
  private String pId;//父节点pId I必须大写
  private String name;//节点名称
  private String open = "false";//是否展开树节点，默认不展开
  private String isParent="true";

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getpId() {
    return pId;
  }

  public void setpId(String pId) {
    this.pId = pId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOpen() {
    return open;
  }

  public void setOpen(String open) {
    this.open = open;
  }

  public String getIsParent() {
    return isParent;
  }

  public void setIsParent(String isParent) {
    this.isParent = isParent;
  }
}