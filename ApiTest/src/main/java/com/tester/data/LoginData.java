package com.tester.data;



import com.tester.model.LoginCase;
import com.tester.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginData {

    @DataProvider(name = "loginData")
    public Object[] loginData() throws IOException {

        //创建一个session用以读取mysql内的测试数据
        SqlSession session = DatabaseUtil.getSqlsession();

        //获取login_case表中id=1的数据
        LoginCase loginCase = session.selectOne("login_case",1);


        //拼接body
        JSONObject param = new JSONObject();
        param.put("mobile",loginCase.getMobile());
        param.put("password",loginCase.getPassword());
        param.put("loginType",loginCase.getLoginType());
        param.put("device_uid",loginCase.getDevice_uid());

        Object[] o = new Object[]{
                param.toString()
        };

        System.out.println("o ="+o[0]);
        return o;

    }
}
