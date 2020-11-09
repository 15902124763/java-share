package com.yarm.test;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class RedPackageBo {
    /**
     * 人数
    */
    private int count;
    /**
     * 红包
     */
    private BigDecimal redPackageMoney;
    /**
     * 红包组
     */
    private List<BigDecimal> redPackageList;
}
