package com.springboot.springbootmybatis;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 入口类
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.springboot.springbootmybatis.mapper")
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        // Guava库中的Stopwatch类，用于测量时间。createStarted()方法创建并启动了一个新的计时器
        Stopwatch started = Stopwatch.createStarted();
        SpringApplication.run(SpringbootMybatisApplication.class, args);
        started.stop();
        log.info("项目启动耗时{}s",started.elapsed().getSeconds());
    }
}
