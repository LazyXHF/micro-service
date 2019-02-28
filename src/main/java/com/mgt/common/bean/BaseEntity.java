package com.mgt.common.bean;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @program: mgt-contrl-platform
 * @description: 基础扩展类
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class BaseEntity implements Serializable{
    @Override
    public String toString() {
        return (new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE){
        }).toString();
    }
}
