package com.lzz.springcloud.service.impl;

import com.lzz.springcloud.Dao.PaymentDao;
import com.lzz.springcloud.entities.Payment;
import com.lzz.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int creat(Payment payment){
        return paymentDao.creat(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
