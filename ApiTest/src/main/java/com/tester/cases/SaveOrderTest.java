package com.tester.cases;


import com.tester.data.SaveOrderData;
import com.tester.execute.SaveOrderClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 支付接口
 */
public class SaveOrderTest extends SaveOrderData {

    private String orderType1 = "hongKongSaveOrder";
    private String orderType2 = "differentSpacePlaceOrder";

    @Test(dataProvider = "saveOrderData",groups ="hongKongPlaceOrder",description = "香港地址下单-支付")
    public void hongKongSaveOrder(String param) throws IOException {
        SaveOrderClass.saveOrderClass(param,orderType1);
    }

    @Test(dataProvider = "saveOrderData",groups ="differentSpacePlaceOrder",description = "多仓下单流程-支付")
    public void differentSpaceSaveOrder(String param) throws IOException {
        SaveOrderClass.saveOrderClass(param,orderType2);
    }
}
