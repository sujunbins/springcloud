package com.junbin.springcloud.Commom.entity;



import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.junbin.springcloud.Commom.Util.JSONUtils;
import com.junbin.springcloud.Commom.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 7129511938622544397L;


    @JsonSerialize(using= ToStringSerializer.class)
    private String id;

    /**
     * <p>
     * 将实体对象转换为对应的数据传输对象
     * </p>
     */
    public static <T extends BaseDTO> T parseDTO(BaseEntity entity, Class<T> dtoClass) {
        T dtoObj = JSONUtils.parseObject(entity, dtoClass);
        dtoObj.setDtoId(entity.getId());
        return dtoObj;
    }

    /**
     * 转换当前实例对象为 DTO对象
     *
     * @param dtoClass
     * @param          <T>
     * @return
     */
    public <T extends BaseDTO> T toDTO(Class<T> dtoClass) {
        T dtoObj = JSONUtils.parseObject(this, dtoClass);
        dtoObj.setDtoId(this.getId());
        return dtoObj;
    }

    /**
     * <p>
     * 将实体集合 列表转化为数据传输对象列表
     * </p>
     */
    public static <T extends BaseDTO> List<T> parseDTOArray(List<? extends BaseEntity> entities, Class<T> dtoClass) {
        List<T> dtoArray = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)) {
            return dtoArray;
        }
        for (BaseEntity entity : entities) {
            dtoArray.add(parseDTO(entity, dtoClass));
        }
        return dtoArray;
    }
}

