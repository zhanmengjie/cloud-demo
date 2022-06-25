package cn.itcast.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class gateway {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication.run(gateway.class,args);
    }
}
