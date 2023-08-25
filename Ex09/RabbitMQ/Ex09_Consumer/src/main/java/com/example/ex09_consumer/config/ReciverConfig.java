package com.example.ex09_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReciverConfig {
    public static final String QUEU = "ex100_queu";
    public static final String EXCHANGE = "ex100_exchange";
    public static final String KEY = "ex100_key";
    @Bean
    public Queue queue()
    {
        return new Queue(QUEU);
    }
    @Bean
    public TopicExchange exchange()
    {
        return new TopicExchange(EXCHANGE);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with(KEY);
    }
}
