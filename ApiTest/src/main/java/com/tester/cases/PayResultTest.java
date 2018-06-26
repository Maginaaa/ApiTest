package com.tester.cases;


import com.tester.data.PayResultData;
import com.tester.execute.PayResultClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 查看支付结果接口
 */
public class PayResultTest extends PayResultData {

    @Test(dataProvider = "payResultData", groups = "hongKongPlaceOrder", description = "香港地址下单-查看支付结果")
    public void hongKongPayResult(String param) throws IOException {
        PayResultClass.payResultClass(param);
    }

    @Test(dataProvider = "payResultData", groups = "differentSpacePlaceOrder", description = "香港地址下单-查看支付结果")
    public void differentSpacePayResult(String param) throws IOException {
        PayResultClass.payResultClass(param);
    }

}
