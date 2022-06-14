package com.junbin.springcloud.Commom.Util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cglib.beans.BeanCopier;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 23:30 2020/1/11
 * @ Description：对象操作类
 **/
public class BeanUtils {
    private static final ConcurrentMap<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<String, BeanCopier>();

    /**
     * 复制类的属性值 - 在get方法和set方法不严格匹配的时候会出问题.
     * @param source      被复制属性的类
     * @param target      复制类
     */
    public static void BeanCopy(Object source, Object target) {
        BeanCopier copier = null;
        String key = GetKey(source.getClass(), target.getClass());
        if (BEAN_COPIERS.containsKey(key)) {
            copier = BEAN_COPIERS.get(key);
        }else {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        }
        copier.copy(source, target, null);
    }

    private static String GetKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getCanonicalName() + "-" + destClazz.getCanonicalName();
    }

    /**
     * 对象集合拷贝
     * @param source	对象集合
     * @param clazz		拷贝对象类
     * @return
     */
    public static <T> List<T> CopyProperties(Collection<?> source, Class<T> clazz) {
        List<T> list = JSONArray.parseArray(JSONObject.toJSONString(source), clazz);
        return list;
    }

}
