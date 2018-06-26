package com.tester.cases;


import com.tester.data.SetNewAddressData;
import com.tester.execute.SetNewAddressClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class SetNewAddressClassTest extends SetNewAddressData {

    @Test(dataProvider = "setNewAddressData", groups = "hongKongPlaceOrder",description = "香港地址下单流程-设置收货地址")
    public void hongKongsetNewAddress(String param) throws IOException {
        SetNewAddressClass.setNewAddressClass(param);
    }

    @Test(dataProvider = "setNewAddressData", groups = "differentSpacePlaceOrder",description = "多仓下单流程-设置收货地址")
    public void differentSpacePlaceOrder(String param) throws IOException {
        SetNewAddressClass.setNewAddressClass(param);
    }


}
