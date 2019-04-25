package com.portjs.base.util.UUID;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author gumingyang
 * @description 去除UUID中的横岗
 **/
public class UuidPlus {
    public static String getUUIDPlus() {
        String src = UUID.randomUUID().toString();
        return src.substring(0, 8) + src.substring(9, 13) + src.substring(14, 18) + src.substring(19, 23) + src.substring(24, 36);
    }


    public static void main(String[] args) {
        System.out.println(UuidPlus.getUUIDPlus());
    }

}
