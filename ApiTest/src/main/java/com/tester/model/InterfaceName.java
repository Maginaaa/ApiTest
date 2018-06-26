package com.tester.model;

public enum InterfaceName {

    /**
     * 以下接口因为url里带变量，所以不在此进行配置
     * 取消订单：/api/rest/wcc/orders/${rderid}/prepay-cancel
     */

    //登录
    LOGIN,

    //加入购物车
    CART,

    //结算
    CHECKOUT,

    //设置收货地址
    SETNEWADDRESS,

    //使用积分支付
    APPLYPOINT,

    //使用优惠券支付
    APPLYCOUPON,

    //支付
    SAVEORDER,

    //查看支付结果
    PAYRESULT

}
