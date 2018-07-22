package com.example.tuancan.enums;

public enum StatusEnum {

    StatusDOWN(0,"停用，不可用"),
    StatusUP(1,"启用，可用"),

    IsDefaultAcoount(0,"不是默认账号"),
    NotDefaultAccount(1,"默认账号"),

    MasterStatusNEW(0,"新建配送单"),
    MasterStatusCOMFIRM(1,"确认配送单"),
    MasterStatusPAY(2,"配送单已支付"),

    NotEmergency(0,"不是应急配送"),
    ISEmergency(1,"应急配送"),

    NotFree(0,"不赠送"),
    IsFree(1,"赠送"),

    QuestionnaireTypeDANXUAN(1,"单选题"),
    QuestionnaireTypeDUOXUAN(2,"多选题"),
    QuestionnaireTypeZHUGUANTI(3,"主管题"),

    Meat(1,"荤菜"),
    Vegetable(2,"素菜"),

    recipeTypeChaoCai(1,"炒菜"),//1：炒菜，2：凉菜，3：汤菜，4：蒸菜，5：烧菜）
    recipeTypeliangCai(2,"凉菜"),
    recipeTypeTangCai(3,"汤菜"),
    recipeTypeZhengCai(4,"蒸菜"),
    recipeTypeShaoCai(5,"烧菜"),

    NotCakes(0,"不是糕点"),
    IsCakes(1,"糕点"),
    ;

    /*状态码*/
    private Integer code;

    private String message="";

    StatusEnum(Integer code) {
        this.code = code;
    }

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
