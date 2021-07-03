package com.lzz.springcloud.controller;

import com.lzz.springcloud.entities.CommonResult;
import com.lzz.springcloud.entities.Payment;
import com.lzz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/creat")
    public CommonResult<Payment> creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("***********create result" +payment+"-_-!`");
        if (result>0){
            return new CommonResult(200,"create successed:" + serverPort,result);
        }else {
            return new CommonResult(500,"create faild",result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********select result" +payment+"-_-!`");
        if (payment != null){
            return new CommonResult(200,"select successed:" + serverPort,payment);
        }else {
            return new CommonResult(500,"select faild",null);
        }
    }

    @GetMapping(value = "/payment/discorvery")
    public Object discorvery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("=========service" +service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
