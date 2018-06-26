package com.tester.model;

import lombok.Data;

@Data
public class AddressCase {

    /**
     * id=1,value=63664代表香港收货地址
     * id=2,value=53050代表大陆收货地址
     */
    private String address_id;
}
