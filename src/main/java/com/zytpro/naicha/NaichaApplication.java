package com.zytpro.naicha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.zytpro.naicha.mapper"})  // 一次性扫描指定包下所有的mapper接口
public class NaichaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaichaApplication.class, args);
    }

}
