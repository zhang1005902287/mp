package com.zsq.mp;

import com.zsq.mp.mapper.UserMapper;
import com.zsq.mp.service.api.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
//@MapperScan(basePackages = "com.zsq.mp.mapper")
public class MpApplication {

    @Autowired
    private UserService userService;



    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class, args);
    }

}
