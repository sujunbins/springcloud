package com.junbin.springcloud.Commom.Request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 20:22 2022/6/7
 * @ Description：${description}
 **/
@Data
public class CompanyRequest {


    @NotNull(message="请输入公司名称")
    @Length(min=1, max=100, message="公司名称限制1-255字符")
    private String name;

    @NotNull(message="请输入公司地区")
    @Length(min=1, max=100, message="公司地区限制1-255字符")
    private String companyArea;

    @NotNull(message="请输入公司地址")
    @Length(min=1, max=100, message="公司地址限制1-255字符")
    private String companyAddress;

    @NotNull(message="请输入公司法人代表")
    @Length(min=1, max=100, message="公司地址限制1-255字符")
    private String businessLicenseId;
    /**
     * 法人代表
     */
    private String legalRepresentative;
    /**
     * 公司电话
     */
    private String companyPhone;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 公司规模
     */
    private String companySize;
    /**
     * 所属行业
     */
    private String industry;



    private Date createTime;
}
