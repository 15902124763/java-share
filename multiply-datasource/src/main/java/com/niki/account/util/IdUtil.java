package com.niki.account.util;

import java.util.UUID;

/**
 * @Description :随机生成id
 * @Author : yarm.yang
 * @Date : 2020/9/7 15:31
*/
public class IdUtil {
    /**
     * @Description :UUID
     * @Author : yarm.yang
     * @Date : 2020/9/7 15:31
     * @Return :
    */
    public static String getUUID(){
      return UUID.randomUUID().toString().replace("-","");
    }
}
