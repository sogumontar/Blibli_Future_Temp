package com.example.template;

import org.apache.commons.lang3.RandomStringUtils;

public class testing {
    public static void main(String[] args) {
//        String generatedString = RandomStringUtils.randomAlphanumeric(20);
        String test="Hendra";
        String sku=test.substring(0,3)+"_";
        System.out.println(sku);
    }
}
