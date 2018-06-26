package com.tester.cases;

import com.tester.config.TestConfig;
import com.tester.model.InterfaceName;
import com.tester.utils.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.BeforeSuite;


public class JointUrl {

    /**
     拼接所有测试接口所需Url
     如果URl接口中携带入参，例如:/wcc/${id}/paypel-cancle等，需要在execute层单独进行拼接
     */
    @BeforeSuite
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.cartUrl = ConfigFile.getUrl(InterfaceName.CART);
        TestConfig.checkoutUrl = ConfigFile.getUrl(InterfaceName.CHECKOUT);
        TestConfig.setNewAddressUrl = ConfigFile.getUrl(InterfaceName.SETNEWADDRESS);
        TestConfig.applyPointUrl = ConfigFile.getUrl(InterfaceName.APPLYPOINT);
        TestConfig.applyCouponUrl = ConfigFile.getUrl(InterfaceName.APPLYCOUPON);
        TestConfig.saveOrderUrl = ConfigFile.getUrl(InterfaceName.SAVEORDER);
        TestConfig.payResultUrl = ConfigFile.getUrl(InterfaceName.PAYRESULT);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
}
