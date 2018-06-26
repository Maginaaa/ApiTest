package com.tester.execute;

import com.tester.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

public class PrepayCancleClass {

    public static void prepayCancleClass(String id) throws IOException {
        //创建post请求用以访问接口

        String url1 = "http://m.wconcept.cn/api/rest/wcc/orders/";
        String url2 = "/prepay-cancel";
        String testUrl = url1+id+url2;
        HttpPost post = new HttpPost(testUrl);
        System.out.println("url ="+testUrl);

        //设置header信息
        post = SetHeader.setHeader(post);
        post.setHeader("Authorization",TestConfig.token);

        //返回结果
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result ="+result);

        //断言
        JSONObject jsonObject = new JSONObject(result);
        String orderId = jsonObject.getString("order_id");

        System.out.println(orderId);
        System.out.println(id);
        Assert.assertEquals(orderId,id);
    }
}
