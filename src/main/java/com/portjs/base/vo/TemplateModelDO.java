package com.portjs.base.vo;

import com.portjs.base.entity.TXietongDictionary;
import org.apache.catalina.LifecycleState;

import java.util.List;

public class TemplateModelDO {
    private  String tpye_code;
    private  List<TXietongDictionary> dictionaries;

    public String getTpye_code() {
        return tpye_code;
    }

    public void setTpye_code(String tpye_code) {
        this.tpye_code = tpye_code;
    }

    public List<TXietongDictionary> getDictionaries() {
        return dictionaries;
    }

    public void setDictionaries(List<TXietongDictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }
}
