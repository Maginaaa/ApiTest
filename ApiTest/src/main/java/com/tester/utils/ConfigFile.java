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
        if (name == InterfaceName.CART){
            uri = bundle.getString("cart.uri");
        }
        if (name == InterfaceName.CHECKOUT){
            uri = bundle.getString("chechout.uri");
        }
        if (name == InterfaceName.SETNEWADDRESS){
            uri = bundle.getString("setNewAddress.uri");
        }
        if (name == InterfaceName.APPLYPOINT){
            uri = bundle.getString("applyPoint.uri");
        }
        if (name == InterfaceName.APPLYCOUPON){
            uri = bundle.getString("applyCoupon.uri");
        }
        if (name == InterfaceName.SAVEORDER){
            uri = bundle.getString("saveOrder.uri");
        }
        if (name == InterfaceName.PAYRESULT){
            uri = bundle.getString("payresult.uri");
        }


        testUrl = address + uri;

        return testUrl;
    }

}
