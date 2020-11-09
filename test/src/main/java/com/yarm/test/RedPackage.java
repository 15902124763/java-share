package com.yarm.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RedPackage {
    /**
     * 最小红包
    */
    private static BigDecimal MIN_RED_PACKAGE = new BigDecimal(0.01);

    public static RedPackageBo getAvgRedPackage(RedPackageBo bo){
        return bo;
    }

    /**
     * @Description :生成平均值
     * @Author : yarm.yang
     * @Date : 2020/7/7 14:10
    */
    private static List<BigDecimal> getAvgRedPackage(BigDecimal money, int count){
        List<BigDecimal> list = new ArrayList<>();
        BigDecimal divide = money.divide(new BigDecimal(count), BigDecimal.ROUND_CEILING, 2);
        BigDecimal multiply = divide.multiply(new BigDecimal(count));
        return list;
    }

    public static void main(String[] args) {
        List<BigDecimal> avgRedPackage = getAvgRedPackage(new BigDecimal(100), 3);
    }
}
