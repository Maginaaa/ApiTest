package com.tester.cases;



import com.tester.data.AddToShoppingData;
import com.tester.execute.AddToShoppingClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class AddToShoppingCartTest extends AddToShoppingData {

    //韩国仓商品
    @Test(dataProvider ="addToShoppingData", groups = {"hongKongPlaceOrder","differentSpacePlaceOrder"}, description = "香港地址下单流程-加入购物车")
    public void hongKongAddToShoppingCart(String param) throws IOException {
        AddToShoppingClass.addToShoppingClass(param);
    }

    //中国仓商品
    @Test(dataProvider ="addToShoppingData", groups = "differentSpacePlaceOrder", description = "多仓位下单流程-加入购物车")
    public void chinaAddToShoppingCart(String param) throws IOException {
        AddToShoppingClass.addToShoppingClass(param);
    }

    //美国仓商品
    @Test(dataProvider ="addToShoppingData", groups = "differentSpacePlaceOrder", description = "多仓位下单流程-加入购物车")
    public void americanAddToShoppingCart(String param) throws IOException {
        AddToShoppingClass.addToShoppingClass(param);
    }



}