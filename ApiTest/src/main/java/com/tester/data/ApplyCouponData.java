package com.tester.data;

import com.tester.config.TestConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class ApplyCouponData {
    @DataProvider(name = "applyCouponData")
    public Object[] applyCouponData(Method method) throws IOException {

        //构造item_ids的value值


        //构造完整的body
        JSONObject param = new JSONObject();

        if (method.getName().equals("hongKongApplyCoupon")){
            JSONArray array = new JSONArray();
            array.put(TestConfig.itemsForHongKongOrder);
            param.put("item_ids",array);
        }else if (method.getName().equals("differentSpaceApplyCoupon")){
            param.put("item_ids",TestConfig.itemsForDifferentOrder);
        }

        param.put("coupon_code","yuangongquan411");
        System.out.println("param = "+param);

        Object[] o = new Object[]{
                param.toString()
        };

        return o;

    }
}
