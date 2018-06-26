package com.tester.data;


import com.tester.model.CartCase;
import com.tester.model.MarqueCase;
import com.tester.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class AddToShoppingData {

    @DataProvider(name = "addToShoppingData")
    public Object[] addToShoppingData(Method method) throws IOException {

        //创建session用以执行sql
        SqlSession session = DatabaseUtil.getSqlsession();

        //创建用以存储cartcase和marque里数据的变量
        CartCase cartCase = session.selectOne("cart_case", 1);
        //韩国仓商品
        MarqueCase marqueCase1 = session.selectOne("marque_case", 1);
        //中国仓商品
        MarqueCase marqueCase2 = session.selectOne("marque_case", 2);
        //美国仓商品
        MarqueCase marqueCase3 = session.selectOne("marque_case", 3);

        //设置body公用信息
        JSONObject param = new JSONObject();
        param.put("is_negativelist", cartCase.getIs_negativelist());
        param.put("device_info", cartCase.getDevice_info());
        param.put("qty", cartCase.getQty());

        //设置body的不同部分
        if (method.getName().equals("hongKongAddToShoppingCart")) {
            //韩国仓商品数据
            paramPutList(param,marqueCase1);

        }else if (method.getName().equals("chinaAddToShoppingCart")){
            //中国仓商品数据
            paramPutList(param,marqueCase2);

        }else if (method.getName().equals("americanAddToShoppingCart")){
            //美国仓商品数据
            paramPutList(param,marqueCase3);

        }

        Object[] o = new Object[]{
                param.toString()
        };

        return o;

    }


    /**
     * 插入商品型号
     * 因为不同商品的型号不一致，但是数据结构一致，所以对param.put(商品型号)的部分进行封装
     */
    public static JSONObject paramPutList(JSONObject param, MarqueCase marqueCase){
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
        param.put("product_id", marqueCase.getProduct_id());
        param.put("simple_product_id", marqueCase.getSimple_product_id());

        return param;
    }
}
