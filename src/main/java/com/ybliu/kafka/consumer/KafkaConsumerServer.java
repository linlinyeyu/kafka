package com.ybliu.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * 自动监听是否有消息需要消费
 */
public class KafkaConsumerServer implements MessageListener<String,String> {
    protected final Logger LOG = LoggerFactory.getLogger("kafkaConsumer");

    public void onMessage(ConsumerRecord<String, String> stringStringConsumerRecord) {
        LOG.info("======开始消费======");
        String topic = stringStringConsumerRecord.topic();
        String key = stringStringConsumerRecord.key();
        String value = stringStringConsumerRecord.value();
        long offset = stringStringConsumerRecord.offset();
        int partition = stringStringConsumerRecord.partition();
        LOG.info("--------topic:"+topic);
        LOG.info("--------value:"+value);
        LOG.info("--------key:"+key);
        LOG.info("--------offset:"+offset);
        LOG.info("--------partition:"+partition);
        LOG.info("--------kafka消费结束--------");
    }
}
