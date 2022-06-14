package com.junbin.springcloud.Commom.dto;


import com.junbin.springcloud.Commom.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * (Department)实体类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {
    private static final long serialVersionUID = -9084332495284489553L;
    //ID

    private String id;
    /**
     * 父级ID
     */
    private String pid;
    /**
     * 企业ID
     */
    private String companyId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 部门编码，同级部门不可重复
     */
    private String code;

    /**
     * 负责人ID
     */
    private String managerId;
    /**
	*  负责人名称
	*/
    private String manager;

    /**
     * 介绍
     */
    private String introduce;
    /**
     * 创建时间
     */
    private Date createTime;
}
