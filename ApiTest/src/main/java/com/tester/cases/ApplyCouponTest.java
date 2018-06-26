package com.tester.cases;


import com.tester.data.ApplyCouponData;
import com.tester.execute.ApplyCouponClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 使用优惠券支付接口
 */
public class ApplyCouponTest extends ApplyCouponData {

    @Test(dataProvider = "applyCouponData", groups = "hongKongPlaceOrder", description = "香港地址下单流程-使用优惠券进行支付")
    public void hongKongApplyCoupon(String param) throws IOException {
        ApplyCouponClass.applyCouponClass(param);
    }

    @Test(dataProvider = "applyCouponData", groups = "differentSpacePlaceOrder", description = "多仓下单流程-使用优惠券进行支付")
    public void differentSpaceApplyCoupon(String param) throws IOException {
        ApplyCouponClass.applyCouponClass(param);
    }


}
