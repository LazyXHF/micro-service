package com.portjs.base.vo;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class ArrayVO {
    private List<String> list;
    private List<T> ObjectList;

    public List<T> getObjectList() {
        return ObjectList;
    }

    public void setObjectList(List<T> objectList) {
        this.ObjectList = objectList;
    }

    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {



        this.list = list;
    }

}
