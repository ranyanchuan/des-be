package com.yyan.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统返回状态值编码
 * Created by rl on 2016/11/29 0001.
 */

public enum ResultCodeEnum {

    //通用技术相关
    SUCCESS("200", "操作成功"),
    FAILED("-1", "请求失败"),
    AUTH_FAIL("-2", "请求验证失败！"),

    PARAM_ERROR("-4", "缺少参数！"),
    USER_ERROR("-5", "未登录或登录信息过期！"),

    //App错误码
    /**
     * 系统级错误码  1 -  200
     */
    APP_REQUEST_ERROR("101", "网络不给力，请稍后~"),//网络延时、数据异常、代码报错、未请求到结果、请求超时等异常状态
    APP_IP_ERROR("102", "您的IP已被封禁,如有疑问,请联系管理员"),
    APP_ACCOUNT_ERROR("103", "您的账号已被封禁,如有疑问,请联系管理员"),
    ACCOUNT_POWER_ERROR("104", "无权限访问此节点"),
    /**
     * 业务级错误码  APP不需要验证  -  只提示  501 - 700
     */
    APP_REGISTER_PHONE_ISNOTNULL("501", "手机号已注册"),//APP登陆-手机号不存在
    APP_LOGIN_PHONE_ISNULL("502", "账号或密码不正确"),//APP登陆-手机号不存在
    APP_SMS_ERROR("503", "验证码错误"),//APP登陆-手机号不存在
    APP_REGISTERCODE_ERROR("504", "邀请码不正确"),//APP注册-邀请码不正确
    APP_SMS_SEND_ERROR("505", "验证码发送失败,请重试"),
    APP_PHONE_ERROR("506", "手机号格式不正确,请重新输入"),
    APP_lOGIN_USER_ERROR("507", "账号异常禁止登陆"),
    APP_SMS_SENDMANY_ERROR("508", "发送超限,明天再试！"),
    APP_USER_IDCARD_ERROR("509", "该身份证号已被绑定"),
    APP_USER_IDCARD_OTHERERROR("510", ""),//身份证号其他错误
    APP_USER_WORD_ERROE("513", "昵称不合法"),
    APP_USER_IDCARD_JyzxUtilERROR("514", "验证身份证失败"),//身份证号其他错误
    APP_GOODS_ACTIVITY_ERROR("520", "本期活动已结束"),
    APP_GOODS_ACTIVITY_TIME_ERROR("521", "活动稍后开始"),
    APP_GOODS_ACTIVITY_OVER_ERROR("522", "商品已被抢完，手速慢了点"),
    APP_AUTH_NAME_ERROR("523", "请先进行实名认证"),
    APP_AUTH_ADDRESS_ERROR("524", "请先填写收货地址"),
    APP_HANGSALE_STATE_ERROR("530", "当前挂拍已结束"),
    APP_ALIPAY_LOGIN_ERROR("537", "支付宝绑定失败"),
    APP_ALIPAY_TRANSFERACCOUNTS_ERROR("538", "支付宝转账失败"),
    APP_ALIPAY_AUTHORIZATION_ERROR("539", "支付宝授权失败"),
    APP_ALIPAY_USER_ERROR("540", "该支付宝账号已被绑定"),
    APP_ALIPAY_CREATEACTIVUTY_ERROR("541", "创建现金活动失败"),
    APP_ALIPAY_PUTFORWARD_ERROR("542", "提现失败"),
    APP_ALIPAY_NO_BOUND_ERROR("544", "请先绑定支付宝"),

    /**
     * 业务级错误码  APP需要验证  -  不提示  801 - 999
     */
    APP_USER_NOIDCARDS_ERROR("805", "未绑定身份证"),
    APP_USER_NOALIPAY_ERROR("806", "未绑定支付宝"),
    APP_REGISTER_PHONE_ISNULL("801", "手机号未注册"),
    APP_lOGIN_TOKEN_ISNULL("802", "登陆信息超时,请重新登陆"),
    APP_lOGIN_TOKEN_UPDATE("803", "你的账号在其他设备上登陆"),
    APP_EDITION_TO_UPDATE("804", "发现新版本，立即体验！");//APP版本更新


    private String code;
    private String message;

    private ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<String, ResultCodeEnum> interToEnum = new HashMap<String, ResultCodeEnum>();

    static {
        for (ResultCodeEnum type : ResultCodeEnum.values()) {
            interToEnum.put(type.getCode(), type);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
