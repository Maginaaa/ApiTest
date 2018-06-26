package com.tester.data;

import com.tester.config.TestConfig;
import com.tester.model.PayResultCase;
import com.tester.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class PayResultData {

    @DataProvider(name = "payResultData")
    public Object[] payResultData(Method method) throws IOException {

        SqlSession session = DatabaseUtil.getSqlsession();
        PayResultCase payResultCase = session.selectOne("pay_result_case",1);

        //构造body
        JSONObject param = new JSONObject();
        param.put("status",payResultCase.getStatus());
        param.put("action",payResultCase.getAction());

        if (method.getName().equals("hongKongPayResult")){
            param.put("order_id",TestConfig.hongKongOrderId);
            System.out.println("orderId = "+TestConfig.hongKongOrderId);
        }else if (method.getName().equals("differentSpacePayResult")){
            param.put("order_id",TestConfig.differentSpaceOrderId);
            System.out.println("orderId = "+TestConfig.differentSpaceOrderId);
        }

        Object[] o = new Object[]{
                param.toString()
        };

        return o;

    }
}
