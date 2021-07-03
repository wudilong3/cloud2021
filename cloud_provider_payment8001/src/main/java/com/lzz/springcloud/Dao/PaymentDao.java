package com.lzz.springcloud.Dao;

import com.lzz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public int creat(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
