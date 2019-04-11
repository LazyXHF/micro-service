package com.portjs.base.util;

import com.portjs.base.dao.PurchaseRequestMapper;
import com.portjs.base.entity.PurchaseRequest;
import com.portjs.base.util.StringUtils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 只针对purchase_request表
 * 使用   LSUtils.
 * 生成格式：createOdd
 * PR+yyMMdd(时间)+0000(四位数)，例如：LL201810100001
 * 生成规则：按当天时间从0001开始累积，今天从LL201810100001开始；明天从LL201810110001开始累积；
 **/
@Component
public class LSUtils {

    private int number;

    @Autowired
    private PurchaseRequestMapper purchaseRequestMapper;

    /**
     *
     */
    private static LSUtils odd;

    @PostConstruct
    public void init() {
        odd = this;
    }

    /**
     * 编写测试流水订单号
     * 测试流水订单号规则：自动生成(PR+8位日期+4位流水号)  示例：LL201809270001
     * @param num
     * @return
     */
    public static String getBody(Integer num) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = String.format("%02d", num);
        return sdf.format(new Date()).substring(0, 8) + str;

    }

    /**
     *截取流水尾号转换数字
     * @param string
     * @return
     */
    public static int getOddCode(String string) {
        int oddCode = Integer.parseInt(string.substring(10));
        return oddCode;

    }

    /**
     * 截取流水单号入库日期
     * @param string
     * @return
     */
    public static int getOddSenttime(String string) {
        int oddSenttime = Integer.parseInt(string.substring(2, 10));
        return oddSenttime;

    }

    public static int getNowTimeCode() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        int nowTimeCode = Integer.parseInt(simpleDateFormat.format(new Date()).substring(0, 8));
        return nowTimeCode;
    }

    /**
     *生成流水单号
     * @return rp  流水单前的类型编号
     */
    public static String createOdd(String rp) {

        String nowOdd=null;
        String oddMaxCode = odd.purchaseRequestMapper.findMaxOdd();
        //如果最大流水单号不为空
        if (!StringUtils.isEmpty(oddMaxCode)) {
            //如果当前时间不相同，例如：20181009=！20180809，重新开始以当天日期拼流水单号201810100001
            if (getNowTimeCode() != getOddSenttime(oddMaxCode)) {
                int number = 1;
                PurchaseRequest express = new PurchaseRequest();
                express.setRequestNum(rp+getBody(number));
                nowOdd = express.getRequestNum();
                //相同，则加1，例如：201810100002
            }else {
                int number = odd.getOddCode(oddMaxCode);
                PurchaseRequest express = new PurchaseRequest();
                express.setRequestNum("PR"+getBody(getOddCode(oddMaxCode)+1));
                nowOdd = express.getRequestNum();
            }
            //如果没有流水单号，以当前日期重新开始生成流水单号
        }else  {
            int number = 1;
            PurchaseRequest express = new PurchaseRequest();

            express.setRequestNum("PR"+getBody(number));

            nowOdd = express.getRequestNum();
        }

        return nowOdd;
    }



}
