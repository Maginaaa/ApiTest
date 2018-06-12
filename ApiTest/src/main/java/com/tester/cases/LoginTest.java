package com.tester.cases;

import com.tester.config.TestConfig;
import com.tester.model.InterfaceName;
import com.tester.model.LoginCase;
import com.tester.utils.ConfigFile;
import com.tester.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoginTest {

    @BeforeTest(groups = "loginTure",description = "测试准备工作")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }


    @Test(groups = "loginTrue",description = "用户登录接口")
    public void login() throws IOException {

        //创建一个session用以读取mysql内的测试数据
        SqlSession session = DatabaseUtil.getSqlsession();

        //获取login_case表中第1行的数据
        LoginCase loginCase = session.selectOne("login_case",1);

        //发送请求
        String result = getResult(loginCase);

        System.out.println("loginCase.getExpected()"+loginCase.getExpected());
        System.out.println("result"+result);
        //验证返回结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("mobile",loginCase.getMobile());
        param.put("password",loginCase.getPassword());
        param.put("device_uid",loginCase.getDevice_uid());
        param.put("loginType",loginCase.getLoginType());

        //设置头信息
        post.setHeader("Content-Type","application/json");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result"+result);

        TestConfig.store = TestConfig.defaultHttpClient.getCookieStore();

        return result;
    }
}
