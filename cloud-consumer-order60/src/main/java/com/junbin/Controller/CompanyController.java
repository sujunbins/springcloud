package com.junbin.Controller;

import com.junbin.springcloud.Commom.Request.CompanyRequest;
import com.junbin.springcloud.Commom.controller.BaseController;
import com.junbin.springcloud.Commom.controller.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 17:29 2022/6/14
 * @ Description：${description}
 **/
@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController extends BaseController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/company";


    @PostMapping("")
    public HttpResult<Object> saveCompany(@RequestBody @Validated CompanyRequest company){
        return restTemplate.postForObject(PAYMENT_URL, company, HttpResult.class);



    }


    @GetMapping("")
    public HttpResult<Object> getCompanys()
    {
        return restTemplate.getForObject(PAYMENT_URL, HttpResult.class);
    }

    @GetMapping("/{id}")
    public HttpResult<Object> getCompany(@PathVariable(value = "id")String id)
    {
        log.info("******** getCompany :  "+id);
        return restTemplate.getForObject(PAYMENT_URL+"/"+id, HttpResult.class);

    }

    @DeleteMapping("/{id}")
    public HttpResult<Object> deleteCompany(@PathVariable(value = "id")String id)
    {
        restTemplate.delete(PAYMENT_URL, id);
        return successResult(null);



    }

    @PutMapping("/{id}")
    public HttpResult<Object> UpdateCompany(@PathVariable(value = "id")String id,@RequestBody CompanyRequest company)
    {
        restTemplate.put(PAYMENT_URL, id);
        return successResult(null);

    }




}
