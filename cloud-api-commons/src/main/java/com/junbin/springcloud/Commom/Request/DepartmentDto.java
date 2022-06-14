package com.junbin.springcloud.Commom.Request;


import com.junbin.springcloud.Commom.dto.Company;
import com.junbin.springcloud.Commom.dto.Department;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 17:18 2022/6/9
 * @ Description：${description}
 **/
@Data
public class DepartmentDto {
    private String companyId;
    private String companyName;
    private String companyManage;

    private List<Department> departments;

    public DepartmentDto(Company company, List<Department> departments)
    {
        this.setCompanyManage(company.getManagerId());
        this.setCompanyName(company.getName());
        this.setCompanyId(company.getId());
        this.departments = departments;
    }

}
