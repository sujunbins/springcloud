package com.junbin.springcloud.Commom.Util;

import java.util.UUID;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 23:18 2020/2/4
 * @ Description：${description}
 **/
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
