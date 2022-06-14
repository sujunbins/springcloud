package com.junbin.springcloud.Controller;

import com.junbin.springcloud.Commom.Request.CompanyRequest;
import com.junbin.springcloud.Commom.controller.BaseController;
import com.junbin.springcloud.Commom.controller.HttpResult;
import com.junbin.springcloud.Server.CompanyFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 21:55 2022/6/14
 * @ Description：${description}
 **/
@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController extends BaseController {
    @Resource
    private CompanyFeignService companyFeignService;

    @Value("${server.port}")
    private String serverPort;



    @PostMapping("")
    public HttpResult<Object> saveCompany(@RequestBody @Validated CompanyRequest company){
        return companyFeignService.saveCompany(company);

    }


    @GetMapping("")
    public HttpResult<Object> getCompanys()
    {
        return companyFeignService.getCompanys();
    }

    @GetMapping("/{id}")
    public HttpResult<Object> getCompany(@PathVariable(value = "id")String id)
    {
        return companyFeignService.getCompany(id);

    }

    @DeleteMapping("/{id}")
    public HttpResult<Object> deleteCompany(@PathVariable(value = "id")String id)
    {
        return companyFeignService.deleteCompany(id);


    }

    @PutMapping("/{id}")
    public HttpResult<Object> UpdateCompany(@PathVariable(value = "id")String id,@RequestBody CompanyRequest company)
    {
        return companyFeignService.UpdateCompany(id, company);

    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // OpenFeign客户端一般默认等待1秒钟
        return companyFeignService.paymentFeignTimeout();
    }


}
