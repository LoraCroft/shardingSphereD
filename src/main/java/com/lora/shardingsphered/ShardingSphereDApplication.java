package com.lora.shardingsphered;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lora.shardingsphered.mapper")
@SpringBootApplication
public class ShardingSphereDApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereDApplication.class, args);
    }

}
