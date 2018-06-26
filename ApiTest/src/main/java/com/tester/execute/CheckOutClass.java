package com.tester.execute;

import com.tester.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckOutClass {

    public static void checkOutClass(String param) throws IOException {

        //创建post请求用以访问cart接口
        HttpPost post = new HttpPost(TestConfig.checkoutUrl);

        //设置头信息
        post = SetHeader.setHeader(post);
        post.setHeader("Authorization",TestConfig.token);

        StringEntity entity = new StringEntity(param, "utf-8");
        post.setEntity(entity);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println("result = "+result);

        //对获取到的结果和预期结果进行处理
        JSONObject jsonObject = new JSONObject(result);
        System.out.println("jsonObject"+jsonObject.toString());
        JSONArray items = jsonObject.getJSONArray("items");

        int item_id = 0;
        System.out.println("items.length() ="+items.length());


        if (items.length() == 1){
            item_id = items.getJSONObject(0).getInt("item_id");
            //将item_id保存下来以便后续接口进行引用
            TestConfig.itemsForHongKongOrder = Integer.toString(item_id);
            System.out.println("TestConfig.itemsForHongKongOrder ="+TestConfig.itemsForHongKongOrder);
        }else if (items.length() > 1){
            int[] array=new int[items.length()];
            TestConfig.itemsForDifferentOrder = new JSONArray();
            //多仓下单中，保存不同商品的item_id
            for (int i=0;i <items.length();i++){
                array[i]= items.getJSONObject(i).getInt("item_id");
                System.out.println("array["+i+"] = "+array[i]);

                TestConfig.itemsForDifferentOrder.put(Integer.toString(array[i]));
            }
            System.out.println("itemsForDifferentOrder ="+ TestConfig.itemsForDifferentOrder);
            item_id = array[0];
        }

        //验证返回结果
        Assert.assertNotNull(item_id);
        Assert.assertNotEquals(item_id,0);


    }

}
