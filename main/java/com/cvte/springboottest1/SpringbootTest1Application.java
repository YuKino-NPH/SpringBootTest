package com.cvte.springboottest1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 测试远程分支修改后与本地分支合并
 * test
 */
@SpringBootApplication
@MapperScan("com.cvte.springboottest1.mapper")
public class SpringbootTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest1Application.class, args);
    }

}
