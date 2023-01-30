package com.zw;

import com.zw.util.Snowflake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement// 开启事物
@SpringBootApplication
//@ImportResource("springbeans.xml")// 导入spring 的xml配置
public class App {
    public static void main(String[] args) {
        // testSnowflake();
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        //System.out.println(applicationContext.getBean("testBean"));
    }

    private static void testSnowflake() {
        try {

            Snowflake idw = new Snowflake(1, 1);
            long ids = idw.nextId();
            for (int i = 0; i < 10000; i++) {
                ids = idw.nextId();
                System.out.println(ids);
            }
        } catch (Exception ex) {

        }
    }
}
