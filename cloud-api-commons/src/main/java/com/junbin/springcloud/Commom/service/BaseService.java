package com.junbin.springcloud.Commom.service;



import com.junbin.springcloud.Commom.dto.BaseDTO;
import com.junbin.springcloud.Commom.entity.BaseEntity;

import java.util.List;

public class BaseService {
    /**
     * 	返回操作成功信息
     * @param mess	说明
     * @param data	数据
     * @return
     */
    protected <T> ServiceResult<T> successResult(String mess, T data) {
        ServiceResult<T> result = new ServiceResult<T>(true, mess, data);
        return result;
    }

    /**
     * 	返回操作失败信息
     * @param mess	说明
     * @param data	数据
     * @return
     */
    protected <T> ServiceResult<T> errorResult(String mess, T data) {
        ServiceResult<T> result = new ServiceResult<T>(false, mess, data);
        return result;
    }

    /**
     * 实体集合转DTO
     * @param entities
     * @param dtoClass
     * @return
     */
    public static <T extends BaseDTO> List<T> parseDTOArray(List<? extends BaseEntity> entities, Class<T> dtoClass) {
        return BaseEntity.parseDTOArray(entities, dtoClass);
    }

    /**
     * DTO集合转实体
     * @param mallBaseDTOS
     * @param entityClass
     * @return
     */
    public static  <T extends BaseEntity> List<T> parseEntityArray(List<? extends BaseDTO> mallBaseDTOS, Class<T> entityClass) {
        return BaseDTO.parseEntityArray(mallBaseDTOS, entityClass);
    }



}
