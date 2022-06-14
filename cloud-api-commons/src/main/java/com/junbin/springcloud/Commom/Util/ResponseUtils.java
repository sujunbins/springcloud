package com.junbin.springcloud.Commom.Util;

import javax.servlet.http.HttpServletResponse;

/**
 * @ Author     ：苏俊宾
 * @ Date       ：Created in 19:34 2020/1/6
 * @ Description：${description}
 **/
public class ResponseUtils {

    public static void configResponse(HttpServletResponse response) {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
    }
}
