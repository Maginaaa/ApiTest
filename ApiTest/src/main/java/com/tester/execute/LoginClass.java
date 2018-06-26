package com.tester.execute;

import com.tester.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;


import java.io.IOException;


public class LoginClass {

    public static void loginClass(String param) throws IOException {

        HttpPost post = new HttpPost(TestConfig.loginUrl);

        //设置头信息
        post = SetHeader.setHeader(post);

        StringEntity entity = new StringEntity(param,"utf-8");
        post.setEntity(entity);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");


        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();

        //对获取到的结果进行处理
        JSONObject object = new JSONObject(result);
        int i = object.getInt("user_id");

        //获取token
        TestConfig.token = object.getString("auth_token");

        //验证返回结果
        Assert.assertNotNull(i);
    }
}
