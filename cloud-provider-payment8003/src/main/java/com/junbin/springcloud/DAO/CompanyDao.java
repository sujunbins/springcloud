package com.junbin.springcloud.DAO;


import com.junbin.springcloud.Commom.dto.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 17:24 2022/6/7
 * @ Description：${description}
 **/
@Mapper
public interface CompanyDao {

    int insert(Company company);

    int insertSelective(Company company);

    List<Company> findById(String id);
    Boolean deleteById(String id);

    List<Company>findByName(String name);

    Boolean updateSelective(Company company);

    List<Company> findAll();


}
