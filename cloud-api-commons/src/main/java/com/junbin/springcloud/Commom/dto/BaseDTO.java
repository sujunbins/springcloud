package com.junbin.springcloud.Commom.dto;


import com.junbin.springcloud.Commom.Util.JSONUtils;
import com.junbin.springcloud.Commom.entity.BaseEntity;
import org.apache.commons.collections.CollectionUtils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDTO  implements Serializable {


    private static final long serialVersionUID = -1375086963901527842L;

    /**
     * 获取数据传输对象的id
     */
    public abstract String getDtoId();

    /**
     * 设置数据传输对象的id
     */
    public abstract void setDtoId(String dtoId);

    /**
     * 将DTO转换为对应的实体类
     */
    public static  <T extends BaseEntity> T parseEntity(BaseDTO baseDTO, Class<T> entityClass) {
        T entityObj = JSONUtils.parseObject(baseDTO, entityClass);
        entityObj.setId(baseDTO.getDtoId());
        return entityObj;
    }

    /**
     * 转换当前dto实例为entity
     */
    public <T extends BaseEntity> T toEntity(Class<T> entityClass) {
        T entityObj = JSONUtils.parseObject(this, entityClass);
        entityObj.setId(this.getDtoId());
        return entityObj;
    }

    /**
     * 将DTO集合列表转换为对应的实体类列表
     */
    public static  <T extends BaseEntity> List<T> parseEntityArray(List<? extends BaseDTO> mallBaseDTOS, Class<T> entityClass) {
        List<T> entityArray = new ArrayList<>();
        if (CollectionUtils.isEmpty(mallBaseDTOS)) {
            return entityArray;
        }
        for (BaseDTO mallBaseDTO : mallBaseDTOS) {
            entityArray.add(parseEntity(mallBaseDTO, entityClass));
        }
        return entityArray;
    }

}
