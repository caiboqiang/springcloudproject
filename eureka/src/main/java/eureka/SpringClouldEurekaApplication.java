package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//TODO Clould服务注册中心
@EnableEurekaServer
public class SpringClouldEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClouldEurekaApplication.class, args);
    }
}
