package com.zsq.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.scheduling.annotation.Async;

@Data
@TableName("tbl_user")
//开启基于注解的Rabbit
@EnableRabbit
public class User {

    @RabbitListener(queues = {"test01"})
    public void receive(User user){
        System.out.println("收到消息"+user);
    }

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String userName;


    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("hello...");
    }
}
