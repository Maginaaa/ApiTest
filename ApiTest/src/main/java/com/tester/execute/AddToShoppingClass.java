package com.tester.execute;

import com.tester.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

public class AddToShoppingClass {
    public static void addToShoppingClass(String param) throws IOException {

        //创建post请求用以访问cart接口
        HttpPost post = new HttpPost(TestConfig.cartUrl);

        //设置头信息
        post = SetHeader.setHeader(post);
        post.setHeader("Authorization", TestConfig.token);

        StringEntity entity = new StringEntity(param, "utf-8");
        post.setEntity(entity);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(), "utf-8");

        //对获取到的结果和预期结果进行处理
        JSONObject jsonObject = new JSONObject(result);
        String resultMessage = jsonObject.getString("message");
        Integer resultCode = jsonObject.getInt("code");

        //验证返回结果
        Assert.assertNotNull(resultMessage);
        Assert.assertEquals(resultCode.toString(),"200");


    }
}
