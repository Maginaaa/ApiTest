package com.tester.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class TestConfig {
    public static String loginUrl;
    public static String cartUrl;
    public static String checkoutUrl;
    public static String setNewAddressUrl;
    public static String applyPointUrl;
    public static String applyCouponUrl;
    public static String saveOrderUrl;
    public static String payResultUrl;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;
    public static String token;

    //香港地址下单流程中，购物车的item_id
    public static String itemsForHongKongOrder;

    //多仓位下单流程中，购物车的item_ids
    public static JSONArray itemsForDifferentOrder;

    //因为考虑之后可能做不同场景多线程的测试，所以这里将不同场景下的order_id分开进行存储
    //香港下单流程中，生成订单的order_id
    public static String hongKongOrderId;
    //多仓下单流程中，生成的订单order_id
    public static String differentSpaceOrderId;


}
