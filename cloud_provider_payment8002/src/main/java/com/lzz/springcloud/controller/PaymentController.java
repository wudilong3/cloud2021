package com.lzz.springcloud.controller;

import com.lzz.springcloud.entities.CommonResult;
import com.lzz.springcloud.entities.Payment;
import com.lzz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/creat")
    public CommonResult<Payment> creat(@RequestBody Payment payment){
        int result = paymentService.creat(payment);
        log.info("***********create result" +payment+"-_-!`");
        if (result>0){
            return new CommonResult(200,"create successed",result);
        }else {
            return new CommonResult(500,"create faild",result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********select result" +payment+"-_-!`");
        if (payment != null){
            return new CommonResult(200,"select successed",payment);
        }else {
            return new CommonResult(500,"select faild",null);
        }
    }

}
