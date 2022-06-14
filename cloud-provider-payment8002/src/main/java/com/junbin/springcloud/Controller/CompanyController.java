package com.junbin.springcloud.Controller;


import com.junbin.springcloud.Commom.Request.CompanyRequest;
import com.junbin.springcloud.Commom.controller.BaseController;
import com.junbin.springcloud.Commom.controller.HttpResult;
import com.junbin.springcloud.Commom.exception.BusinessException;
import com.junbin.springcloud.Commom.resultcode.BaseResultCodeEnum;
import com.junbin.springcloud.Server.CompanyServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 20:10 2022/6/7
 * @ Description：${description}
 **/
@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController extends BaseController {

    @Autowired
    private CompanyServer companyServer;

    @Autowired
    private RedisTemplate  redisTemplate;

    @Value("${server.port}")
    private String serverPort;//添加serverPort

    @PostMapping("")
    public HttpResult<Object> saveCompany(@RequestBody @Validated CompanyRequest company){
        if (company==null)
        {
            throw new BusinessException(BaseResultCodeEnum.PARAM_ERROR);
        }

        companyServer.AddCompany(company);
        return successResult(serverPort);


    }


    @GetMapping("")
    public HttpResult<Object> getCompanys()
    {
        return successResult(companyServer.findAll()+serverPort);
    }

    @GetMapping("/{id}")
    public HttpResult<Object> getCompany(@PathVariable(value = "id")String id) throws InterruptedException {

        if (StringUtils.isEmpty(id)) {
            return errorResult("参数不能为空", serverPort);
        }
        return successResult(companyServer.findById(id)+serverPort);
    }

    @DeleteMapping("/{id}")
    public HttpResult<Object> deleteCompany(@PathVariable(value = "id")String id)
    {

        if (StringUtils.isEmpty(id)) {
            return errorResult("参数不能为空", serverPort);
        }
        companyServer.deleteCompany(id);
        return successResult(serverPort);

    }

    @PutMapping("/{id}")
    public HttpResult<Object> UpdateCompany(@PathVariable(value = "id")String id,@RequestBody CompanyRequest company)
    {
        if (StringUtils.isEmpty(id)) {
            return errorResult("参数不能为空", serverPort);
        }
        companyServer.UpdateCompany(id,company);
        return successResult(serverPort);
    }
}
