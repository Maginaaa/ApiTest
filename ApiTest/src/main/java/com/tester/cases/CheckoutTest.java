package com.tester.cases;

import com.tester.data.CheckOutData;
import com.tester.execute.CheckOutClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutTest extends CheckOutData {
    @Test(dataProvider = "checkOutData",groups = "hongKongPlaceOrder", description = "香港地址下单流程-结算")
    public void hongKongCheckout(String param)throws IOException {
       CheckOutClass.checkOutClass(param);
    }

    @Test(dataProvider = "checkOutData",groups = "differentSpacePlaceOrder", description = "多仓下单流程-结算")
    public void differentSpaceCheckout(String param)throws IOException {
        CheckOutClass.checkOutClass(param);
    }


}
