package com.tester.data;

import com.tester.config.TestConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;


import java.lang.reflect.Method;

public class ApplyPointData {
    @DataProvider(name = "applyPointData")
    public Object[] applyPointData(Method method){

        //构造完整的body
        JSONObject param = new JSONObject();

        //构造item_ids的value值
        if (method.getName().equals("hongKongApplyPoint")){

            JSONArray array = new JSONArray();
            array.put(TestConfig.itemsForHongKongOrder);
            param.put("item_ids",array);

        }else if (method.getName().equals("differentSpaceApplyPoint")){

            for (int i=0;i<TestConfig.itemsForDifferentOrder.length();i++){
                param.put("item_ids",TestConfig.itemsForDifferentOrder);
            }

        }

        System.out.println("param ="+param.toString());

        Object[] o = new Object[]{
                param.toString()
        };

        return o;

    }
}
