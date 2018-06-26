package com.tester.model;

import lombok.Data;

@Data
public class SaveOrderCase {

    /**
     * 生成订单接口的基础信息部分在此配置
     * 收货地址信息请查看AddressCase
     * 收货人信息请查看PayerCase
     */
    private String download_market;
    private String phone_type;
    private String payment_method;
    private String latest_version;
    private String app_version;
    private String phone_system_version;
    private String api_version;
    private String device_type;
    private String wcc_invoice_type;
}
