package com.junbin.springcloud.Server;

import com.junbin.springcloud.Commom.Request.CompanyRequest;
import com.junbin.springcloud.Commom.controller.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 21:56 2022/6/14
 * @ Description：${description}
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface CompanyFeignService {


    @PostMapping("/company")
    HttpResult<Object> saveCompany(@RequestBody @Validated CompanyRequest company);

    @GetMapping("/company")
    HttpResult<Object> getCompanys();

    @GetMapping("/company/{id}")
    HttpResult<Object> getCompany(@PathVariable("id")String id);


    @DeleteMapping("/company/{id}")
    HttpResult<Object> deleteCompany(@PathVariable("id")String id);
;

    @PutMapping("/company/{id}")
    HttpResult<Object> UpdateCompany(@PathVariable("id")String id,@RequestBody @Validated CompanyRequest company);


    @GetMapping(value = "/company/feign/timeout")
    String paymentFeignTimeout();


;
}
