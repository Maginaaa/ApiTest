package com.tester.cases;


import com.tester.data.ApplyPointData;
import com.tester.execute.ApplyPointClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 使用积分支付接口
 */
public class ApplyPointTest extends ApplyPointData {

    @Test(dataProvider = "applyPointData", groups = "hongKongPlaceOrder", description = "香港地址下单流程-使用积分进行支付")
    public void hongKongApplyPoint(String param) throws IOException {
        ApplyPointClass.applyPointClass(param);
    }

    @Test(dataProvider = "applyPointData", groups = "differentSpacePlaceOrder", description = "多仓下单流程-使用积分进行支付")
    public void differentSpaceApplyPoint(String param) throws IOException {
        ApplyPointClass.applyPointClass(param);
    }


}
