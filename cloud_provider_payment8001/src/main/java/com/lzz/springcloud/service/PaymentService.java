package com.lzz.springcloud.service;

import com.lzz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int creat(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
