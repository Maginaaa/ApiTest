package com.tester.data;


import com.tester.config.TestConfig;
import com.tester.model.AddressCase;
import com.tester.model.PayerCase;
import com.tester.model.SaveOrderCase;
import com.tester.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class SaveOrderData {

    @DataProvider(name = "saveOrderData")
    public Object[] saveOrderData(Method method) throws IOException {

        //获取生成订单的各种基础信息
        SqlSession session = DatabaseUtil.getSqlsession();
        SaveOrderCase saveOrderCase = session.selectOne("save_order_case",1);

        //获取收货人信息
        PayerCase payerCase = session.selectOne("payer_case",1);

        //body共有部分
        JSONObject param = new JSONObject();
        param.put("download_market",saveOrderCase.getDownload_market());
        param.put("phone_type",saveOrderCase.getPhone_type());
        param.put("payment_method",saveOrderCase.getPayment_method());
        param.put("latest_version",saveOrderCase.getLatest_version());
        param.put("app_version",saveOrderCase.getApp_version());
        param.put("phone_system_version",saveOrderCase.getPhone_system_version());
        param.put("api_version",saveOrderCase.getApi_version());
        param.put("device_type",saveOrderCase.getDevice_type());
        param.put("wcc_invoice_type",saveOrderCase.getWcc_invoice_type());
        param.put("payer_id_number",payerCase.getPayer_id_number());
        param.put("payer_name",payerCase.getPayer_name());

        //body在不同用测试场景下数据不同的部分
        if (method.getName().equals("hongKongSaveOrder")){

            JSONArray array = new JSONArray();
            array.put(TestConfig.itemsForHongKongOrder);
            param.put("item_ids",array);

            //香港收货地址
            AddressCase addressCase = session.selectOne("address_case",1);
            param.put("address_id",addressCase.getAddress_id());
        }else if (method.getName().equals("differentSpaceSaveOrder")){

            param.put("item_ids",TestConfig.itemsForDifferentOrder);

            //大陆收货地址
            AddressCase addressCase = session.selectOne("address_case",2);
            param.put("address_id",addressCase.getAddress_id());
        }


        Object[] o = new Object[]{
                param.toString()
        };

        return o;

    }



}
