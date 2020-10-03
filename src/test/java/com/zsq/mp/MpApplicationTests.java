package com.zsq.mp;

import com.zsq.mp.entity.User;
import com.zsq.mp.mapper.UserMapper;
import com.zsq.mp.service.impl.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MpApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private MailServiceImpl mailServiceImpl;
    private String string;

    @Test
    public void send(){
        Map<Object,Object> map = new HashMap<>();
        map.put("hello", "world");
        map.put("tom", "cat");
        rabbitTemplate.convertAndSend("zsq.direct", "test01", map);
        List<String> l = new ArrayList<>();
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("test01");
        System.out.println(o.getClass());
        System.out.println(o);

    }

    @Test
    public void create(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.direct"));
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue"
                ,Binding.DestinationType.QUEUE
                ,"amqpAdmin.direct","amqpAdmin.key",null));
    }

    @Test
    public void sendMessage() throws MessagingException {
        mailServiceImpl.sendMimeMessage();
    }
}
