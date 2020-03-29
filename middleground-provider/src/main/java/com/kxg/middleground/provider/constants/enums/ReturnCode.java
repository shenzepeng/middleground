package com.kxg.middleground.provider.constants.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Auther: szp
 * @Date: 2019/11/24 16:16
 * @Description: 沈泽鹏写点注释吧
 */
public enum ReturnCode {
    SUCCESS("00000", null),
    LOGIN_FAIL("10000","用户名密码错误"),
    USERNAME_NULL("10001","用户名为空"),
    PASSWORD_NULL("10002","密码为空"),
    USER_NULL("10003","用户不存在"),
    USER_EXIST("10004","用户已经存在"),
    OPENID_EXIST("10005","openId已经存在"),
    LOST_SOME_PARAMETER("10006","缺少参数"),
    NO_CHECKIN_EXIST("10007","当前没有签到"),
    CAN_NOT_DELETE_THIS_CLASS("10008","不能删除当前课堂,因为当前课堂有血学生"),
    THIS_STUDENT_DOSE_NOT_EXIST("10009","当前学生不存在"),
    STUDENT_HAS_ADD("10009","该学生已经添加了，不能再次添加"),
    CAN_NOT_ADD_NEW_CHECK("10010","不能再添加签到，还有签到在进行中"),
    THIS_TEACHER_IS_NOT_EXIST("10011","当前老师不存在"),
    LOST_POSITION_IFNO("10012","缺少地理位置信息"),
    QUEST_FAIL("99999","请求失败");

    private String code;
    private String msg;
    private static final Map<String,ReturnCode> CODE_MAP = Maps.newHashMap();
    static{
        ReturnCode[] values = ReturnCode.values();
        for(ReturnCode returnCode : values){
            CODE_MAP.put(returnCode.code,returnCode);
        }
    }
    ReturnCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public String getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public static ReturnCode get(String code){
        return CODE_MAP.get(code);
    }
}
