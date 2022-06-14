package com.junbin.springcloud.Server;


import com.junbin.springcloud.Commom.Request.CompanyRequest;
import com.junbin.springcloud.Commom.Util.BeanUtils;
import com.junbin.springcloud.Commom.Util.Snowflake;
import com.junbin.springcloud.Commom.dto.Company;
import com.junbin.springcloud.Commom.exception.BusinessException;
import com.junbin.springcloud.Commom.resultcode.BaseResultCodeEnum;
import com.junbin.springcloud.Commom.service.BaseService;
import com.junbin.springcloud.DAO.CompanyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 19:42 2022/6/7
 * @ Description：${description}
 **/
@Service
public class CompanyServer extends BaseService {

    @Resource
    private CompanyDao companyDao;

    public void AddCompany(CompanyRequest companyRequestr) {
        String id =  String.valueOf(Snowflake.getSnowflakeId());
        Company company = new Company();
        BeanUtils.BeanCopy(companyRequestr,company);
        company.setId(id);

        //审核状态 0：未审核 1：审核
        company.setAuditState("0");

        //激活状态 0：未激活，1：激活
        company.setState(1);
        companyDao.insertSelective(company);

    }

    public void UpdateCompany(String id,CompanyRequest companyRequest)
    {
        Company company = companyDao.findById(id).get(0);

        if(company !=null)
        {
            BeanUtils.BeanCopy(companyRequest,company);
            companyDao.updateSelective(company);
        }else {
            throw new BusinessException(BaseResultCodeEnum.DATBASE_NON_EXISTENT,"警告：用户"+company.getName()+"不存在！");
        }
    }


    public Company findById(String id)
    {
        Company company = companyDao.findById(id).get(0);
        if(company!=null)
        {
            return company;
        }
        else throw new BusinessException(BaseResultCodeEnum.QUERY_OBJ_CANT_NULL);
    }

    public List<Company> findAll()
    {
        List<Company> companies = companyDao.findAll();
        if(!companies.isEmpty())
        {
            return companies;
        }
        else throw new BusinessException(BaseResultCodeEnum.LIST_EMPTY);
    }

    public void deleteCompany(String id)
    {
        Company company = companyDao.findById(id).get(0);
        if(company!=null)
        {
            companyDao.deleteById(id);
        }
        else throw new BusinessException(BaseResultCodeEnum.QUERY_OBJ_CANT_NULL);
    }

}
