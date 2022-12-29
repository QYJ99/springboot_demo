package com.example.mpdemo.controller;


import com.example.mpdemo.entity.Order;
import com.example.mpdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

//    插入数据
    @PostMapping("/order")
    public String saveOrder(Order order){
        int r = orderMapper.insert(order);
        if(r > 0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }

    @GetMapping("/order/findAll")
    public List findAll(){

        List orders = orderMapper.selectAllOrderAndUser();
        return orders;
    }



}
