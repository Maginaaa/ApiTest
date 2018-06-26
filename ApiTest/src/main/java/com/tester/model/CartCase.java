package com.tester.model;

import lombok.Data;

@Data
public class CartCase {
    /**
     * 加入购物车接口，除商品属性以外的所有其他字段
     * 商品属性存在MarqueCase中
     */
    private String is_negativelist;
    private String device_info;
    private String qty;
    private String expected;

}
