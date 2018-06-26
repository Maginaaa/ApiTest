package com.tester.model;

import lombok.Data;

@Data
public class MarqueCase {
    /**
     * MarqueCase中仅用于储存商品属性值
     * 在加入购物车或者结算等接口的测试中，需要与其他Case结合使用
     */

    //nomal商品id
    private String product_id;

    //simple商品id
    private String simple_product_id;

    //simple商品详细属性
    private String option_id1;
    private String attribute_id1;

    private String option_id2;
    private String attribute_id2;

}
