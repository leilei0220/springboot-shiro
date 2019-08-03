package com.example.leilei.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Utils {

    public static final String SALT = "fm";
    public static final int ITERATIONS = 10;

    /**
     * 加密
     * @param source
     * @return
     */
    public static String encrype(String source){
        SimpleHash simpleHash = new SimpleHash("MD5",source,SALT,ITERATIONS);
        return simpleHash.toString();
    }

    public static void main(String[] args) {

        System.out.println(encrype("admin"));

    }

}
