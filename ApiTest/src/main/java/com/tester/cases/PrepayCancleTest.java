package com.tester.cases;

import com.tester.config.TestConfig;
import com.tester.execute.PrepayCancleClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 取消订单接口
 */
public class PrepayCancleTest {

    @Test(groups = "hongKongPlaceOrder",description = "香港地址下单流程-取消订单")
    public void hongKongPrepayCancle()throws IOException{
        PrepayCancleClass.prepayCancleClass(TestConfig.hongKongOrderId);
    }

    @Test(groups = "differentSpacePlaceOrder",description = "多仓下单流程-取消订单")
    public void differentSpacePrepayCancle()throws IOException{
        PrepayCancleClass.prepayCancleClass(TestConfig.differentSpaceOrderId);
    }
}
