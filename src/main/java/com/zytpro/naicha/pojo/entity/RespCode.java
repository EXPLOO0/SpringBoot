package com.zytpro.naicha.pojo.entity;

/**
 * @Description：自定义的响应码
 * @Author：ZYT
 * @Date：2023/8/6 15:10
 */
public enum RespCode {
    SUCCESS("0","请求成功"),
    ERROR_1("5001","账号密码错误"),
    ERROR_2("5002","获取失败"),
    ERROR_3("5003","搜索的数据不存在！"),
    ERROR_4("5004","未输入信息!!"),
    ERROR_5("5005","添加数据失败!!"),
    ERROR_6("5006","修改数据失败!!"),
    ERROR_7("5007","删除数据失败!!"),
    ERROR_8("5008", "手机号不能为空"),
    ERROR_9("5009", "密码不能为空"),
    ERROR_10("5010", "该手机号已注册"),
    ERROR_11("50011","上传数据失败!!"),
    FAIL("9999","网络错误");

    /**
     * 自定义的响应码，方便前端接收判断。不是响应报文中的状态码！！
     */
    private String code;
    /**
     * 自定义响应码的描述
     */
    private String msg;

    RespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
