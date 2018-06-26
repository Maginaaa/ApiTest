package com.tester.data;


import com.tester.model.MarqueCase;
import com.tester.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * 结算接口
 */
public class CheckOutData {

    @DataProvider(name = "checkOutData")
    public Object[] checkOutData(Method method) throws IOException {

        //创建session用以执行sql
        SqlSession session = DatabaseUtil.getSqlsession();

        //韩国仓商品
        MarqueCase marqueCase1 = session.selectOne("marque_case", 1);
        //中国仓商品
        MarqueCase marqueCase2 = session.selectOne("marque_case", 2);
        //美国仓商品
        MarqueCase marqueCase3 = session.selectOne("marque_case", 3);

        //设置body信息
        JSONArray paramArray = new JSONArray();


        if (method.getName().equals("hongKongCheckout")){
            paramArrayPutParam(paramArray,marqueCase1);
        }else if (method.getName().equals("differentSpaceCheckout")){
            paramArrayPutParam(paramArray,marqueCase1);
            paramArrayPutParam(paramArray,marqueCase2);
            paramArrayPutParam(paramArray,marqueCase3);
        }
        Object[] o = new Object[]{
                paramArray.toString()
        };

        return o;

    }

    public static void paramArrayPutParam(JSONArray paramArray, MarqueCase marqueCase){
        JSONObject param = new JSONObject();
        param.put("product_id", marqueCase.getProduct_id());
        param.put("simple_product_id", marqueCase.getSimple_product_id());
        param.put("section", 0);
        List<JSONObject> list = Lists.newArrayList();
        JSONObject marque1 = new JSONObject();
        marque1.put("option_id", marqueCase.getOption_id1());
        marque1.put("attribute_id", marqueCase.getAttribute_id1());
        list.add(marque1);
        JSONObject marque2 = new JSONObject();
        marque2.put("option_id", marqueCase.getOption_id2());
        marque2.put("attribute_id", marqueCase.getAttribute_id2());
        list.add(marque2);
        param.put("options", list);
        param.put("qty",1);
        paramArray.put(param);
    }
}
