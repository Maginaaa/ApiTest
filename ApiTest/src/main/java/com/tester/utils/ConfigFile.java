package com.tester.utils;

import com.tester.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application",Locale.CHINA);
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        //最终测试地址
        String testUrl;

        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        testUrl = address + uri;

        return testUrl;
    }

}
