package com.tester.model;


import lombok.Data;

@Data
public class LoginCase {

    // 用户登录手机号
    private String mobile;

    // 用户登录密码
    private String password;

    // 设备id
    private String device_uid;

    // 登录方式，测试数据填写为3，ios
    private String loginType;
}
