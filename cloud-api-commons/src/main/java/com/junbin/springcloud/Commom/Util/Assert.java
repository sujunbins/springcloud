package com.junbin.springcloud.Commom.Util;

import com.junbin.springcloud.Commom.exception.BusinessException;
import com.junbin.springcloud.Commom.resultcode.BaseResultCodeEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;


import java.util.Collection;

public class Assert {
    /**
     * <p>
     * 校验对象是否存在
     * </p>
     *
     * <pre>
     * 对象不为空即是存在：抛出异常
     * 若对象为boolean类型则 为true是表示存在 抛出异常，否则表示不存在
     * </pre>
     *
     * @param obj          : List : 待校验obj实例
     * @param formatValues : Object... : 格式化错误信息的的值
     */
    public static void verifyDataExistent(Object obj, Object... formatValues) {
        if (obj == null) {
            return;
        }
        Class<? extends Object> objClass = obj.getClass();
        if (Boolean.class.equals(objClass) || boolean.class.equals(objClass)) {
            if (!(Boolean) obj) {
                return;
            }
        }
        throw new BusinessException(BaseResultCodeEnum.DATBASE_ALREADY_EXISTENT, null, formatValues);
    }

    /**
     * <p>
     * 校验对象是否不存在
     * 若对象为boolean类型则 为false是表示不存在 抛出异常，否则表示不存在
     * </p>
     *
     * <pre>
     * 数据为空即是不存在:抛出异常
     * </pre>
     *
     * @param obj          : List : 待校验obj实例
     * @param formatValues : Object... : 格式化错误信息的的值
     */
    public static void verifyDataNotExistent(Object obj, Object... formatValues) {
        BusinessException exception = new BusinessException(BaseResultCodeEnum.DATBASE_NON_EXISTENT, null, formatValues);
        if (obj == null) {
            throw exception;
        }
        Class<? extends Object> objClass = obj.getClass();
        if (Boolean.class.equals(objClass) || boolean.class.equals(objClass)) {
            if (!(Boolean) obj) {
                throw exception;
            }
        }
    }

    /**
     * <p>
     * 校验对象是否为空
     * </p>
     *
     * <pre>
     * 对象为空抛出异常
     * </pre>
     *
     * @param obj          : List : 待校验obj实例
     * @param formatValues : Object... : 格式化错误信息的的值
     */
    public static void verifyObjNull(Object obj, Object... formatValues) {
        if (obj == null) {
            throw new BusinessException(BaseResultCodeEnum.OBJECT_CANT_NULL, null, formatValues);
        }
    }

    /**
     * <p>
     * 校验列表为空
     * </p>
     *
     * <pre>
     * 列表为空抛出异常
     * </pre>
     *
     * @param obj          : List : 待校验的List实例
     * @param formatValues : Object... : 格式化错误信息的的值
     */
    public static void verifyListNull(Collection<?> obj, Object... formatValues) {
        if (obj == null) {
            throw new BusinessException(BaseResultCodeEnum.LIST_NULL, null, formatValues);
        }
    }

    /**
     * <p>
     * 校验列表为空列表: 抛出异常
     * </p>
     *
     * <pre>
     * 列表为空抛出异常
     * </pre>
     *
     * @param obj          : List : 待校验的List实例
     * @param formatValues : Object... : 格式化错误信息的的值
     */
    public static void verifyListEmpty(Collection<?> obj, Object... formatValues) {
        verifyListNull(obj, formatValues);
        if (CollectionUtils.isEmpty(obj)) {
            throw new BusinessException(BaseResultCodeEnum.LIST_EMPTY, null, formatValues);
        }
    }

    /**
     * <p>
     * 校验字符串是否为空或者空串
     * </p>
     *
     * <pre>
     * 字符串为空串抛出异常
     * </pre>
     *
     * @param str          : List : 待校验的String实例
     * @param formatValues : Object... : 格式化错误信息的的值
     */
    public static void verifyStrEmpty(String str, Object... formatValues) {
        if (StringUtils.isEmpty(str)) {
            throw new BusinessException(BaseResultCodeEnum.STR_EMPTY, null, formatValues);
        }
    }
}
