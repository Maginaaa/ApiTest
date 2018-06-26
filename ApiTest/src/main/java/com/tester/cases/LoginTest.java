package com.tester.cases;


import com.tester.data.LoginData;
import com.tester.execute.LoginClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends LoginData{


    @Test(dataProvider = "loginData",groups = "loginTrue",description = "用户登录接口")
    public void login(String param) throws IOException {
        LoginClass.loginClass(param);
    }
}
