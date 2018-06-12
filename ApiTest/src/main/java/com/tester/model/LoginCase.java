package com.tester.model;


import lombok.Data;

@Data
public class LoginCase {
    private int id;
    private String mobile;
    private String password;
    private String device_uid;
    private String loginType;
    private String expected;
}
