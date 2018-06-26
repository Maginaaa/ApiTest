package com.tester.data;

import com.tester.model.AddressCase;
import com.tester.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class SetNewAddressData {

    @DataProvider(name = "setNewAddressData")
    public Object[] setNewAddressData(Method method) throws IOException {

        //创建session用以执行sql
        SqlSession session = DatabaseUtil.getSqlsession();

        //香港收货地址
        AddressCase addressCase1 = session.selectOne("address_case",1);
        //大陆收货地址
        AddressCase addressCase2 = session.selectOne("address_case",2);

        //设置body信息
        JSONObject param = new JSONObject();

        if (method.getName().equals("hongKongsetNewAddress")){

                param.put("address_id", addressCase1.getAddress_id());

        }else if (method.getName().equals("differentSpacePlaceOrder")){

                param.put("address_id", addressCase2.getAddress_id());
            System.out.println("addressCase2.getAddress_id() ="+addressCase2.getAddress_id());

        }

        System.out.println("address_id ="+param.toString());

        Object[] o = new Object[]{
                param.toString()
        };

        return o;
    }
}
