package com.zytpro.naicha.pojo.entity;

/**
 * @Description：发返回给前端的数据，包括响应码、信息、数据
 * @Author：ZYT
 * @Date：2023/8/6 15:11
 */
public class RespData {
    /**
     * 自定义响应码
     */
    private String code;
    /**
     * 自定义响应码的描述
     */
    private String msg;
    /**
     * 传递给前端的数据
     */
    private Object data;

    /**
     * 返回 "错误"，无数据
     * @param code：自定义响应码
     */
    public RespData(RespCode code){
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    /**
     * 返回 "成功",有数据
     * @param code：自定义响应码
     * @param data：返回的数据
     */
    public RespData(RespCode code, Object data){
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
