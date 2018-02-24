package com.ybliu.kafka;

import com.ybliu.kafka.producer.KafkaProducerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springContext.xml")
public class KafkaProducerTest {
    @Autowired
    private KafkaProducerServer kafkaProducerServer;
    @Test
    public void testProduct(){
        String topic = "orderTopic";
        String value = "test";
        String ifPartition = "0";
        Integer partitionNum = 3;
        String role = "test";
        Map<String,Object> res = kafkaProducerServer.sndMesForTemplate(topic,value,ifPartition,partitionNum,role);
        System.out.println("测试结果如下:=======");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);
    }
}
