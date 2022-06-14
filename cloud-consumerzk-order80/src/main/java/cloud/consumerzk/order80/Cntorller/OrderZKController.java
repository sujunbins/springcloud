package cloud.consumerzk.order80.Cntorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 14:09 2022/6/6
 * @ Description：${description}
 **/
@RestController
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;



    @RequestMapping(value = "/consumer/payment/zk")
    public String paymentinfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }
}
