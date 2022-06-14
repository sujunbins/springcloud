package com.junbin.springcloud.Commom.Util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONUtils {
    /**
     * 将Object对象转换为json字符串，若不能转换将String.valueOf(obj)
     */
    public static String toJSONString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return obj.toString();
        }
        try {
            return JSONObject.toJSONString(obj);
        } catch (JSONException e) {
            return String.valueOf(obj);
        } catch (UnsupportedOperationException e) {
            return String.valueOf(obj);
        } catch (IllegalStateException e) {
            return String.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将obj转化为class对应的泛型对象
     *
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseObject(Object obj, Class<T> clazz) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                obj = JSONObject.parse(obj.toString());
            }
            String jsonStr = toJSONString(obj);
            return JSONObject.parseObject(jsonStr, clazz);
        } catch (JSONException e) {
            return (T) obj;
        } catch (UnsupportedOperationException e) {
            return (T) obj;
        } catch (IllegalStateException e) {
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将json数格式的字符串或者list转换为Class对应泛型对象的集合
     *
     * @param listOrJsonStr
     * @param clazz
     * @return List<T>
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseArray(Object listOrJsonStr, Class<T> clazz) {
        if (listOrJsonStr == null || clazz == null) {
            return null;
        }
        String arrStr = listOrJsonStr.toString();
        if (StringUtils.isEmpty(arrStr)) {
            return null;
        }
        try {
            if (listOrJsonStr instanceof List) {
                arrStr = JSONArray.toJSONString(listOrJsonStr);
            }
            return JSONArray.parseArray(arrStr, clazz);
        } catch (Exception e) {
            List<T> retList = new ArrayList<>();
            retList.add((T) arrStr);
            return retList;
        }
    }

    /**
     * <p>
     * 将fromList中的数据转换为泛型list数据
     * </p>
     *
     * @param fromList : List : 任意泛型Collection
     * @param clazz    : 泛型class
     * @return 泛型list
     *
     */
    public static <T> List<T> fromListToTList(Collection<?> fromList, Class<T> clazz) {
        List<T> retList = new ArrayList<>();
        if (CollectionUtils.isEmpty(fromList)) {
            return retList;
        }
        for (Object obj : fromList) {
            retList.add(JSONUtils.parseObject(obj, clazz));
        }
        return retList;
    }
}
