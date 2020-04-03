package com.myspring.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing  // JPA Auditing 활성화   //p.221
@SpringBootApplication  //1.스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 2.해당 명령어가 있는 위치부터 설정을 읽기때문에 !!항상 프로젝트의 최상단에 위치해야함
public class Application {  //앞으로 만들 클래스의 메인클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); // SpringApplication.run 내장 was 실행 (내장 was쓰는걸 권장)
    }
}
