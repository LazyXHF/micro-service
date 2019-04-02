package com.portjs.base.util;

/**
 *  通用校验工具
 * @author gumingyang
 **/
public class ValidateUtils {
    public static final String REG_1="[A-Z]+";
    public static final String REG_2="[a-z]+";

    /**
     *  大写字母校验
     * @param str
     * @return
     */
    public static Boolean CapitalizeEnglish(String str){
        if(REG_1.matches(str)){
            return true;
        }
        return false;
    }

    /**
     *  小写字母校验
     * @param str
     * @return
     */
    public static Boolean LowercaseEnglish(String str){
        if(REG_2.matches(str)){
            return true;
        }
        return false;
    }
}
