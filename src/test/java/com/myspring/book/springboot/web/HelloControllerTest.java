package com.myspring.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
테스트를 진행할떄 JUnit에 내장된 실행자 외에 다른 실행자를 실행
SpringRunner 라는 스프링 실행자를 사용한다
!!스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다
 */
@RunWith(SpringRunner.class)
@WebMvcTest // p.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;    // 웹 api를 테스트 할때 사용한다   //스프링 MVC 테스트의 시작점  //이 클래스를 통해서 HTTP GET, POST 등에 대한 API테스트를 할수 있다.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))      // MockMvc를 통해 /hello주소로 HTTP GET 요청을 한다.
                                                        // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있다.
                .andExpect(status().isOk())         // mvc.perform의 결과를 검증
                                                        // HTTP Header의 Status 를 검증한다.
                                                        // 200,404,500 등의 Status 검증
                .andExpect(content().string(hello));// 응답본문의 내용을 검증한다.
                                                        //Controller에서 "hello"를 리턴하기때문에 이 값이 맞는지 검증한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                                    .param("name",name)             // API 테스트할때 사용될 요청 파라미터를 설정한다
                                                                                //!!! 단!! 값은 String만 허용된다.
                                                                                // 숫자/날짜 등의 데이터도 등록할때는 문자열로 변경해야만 가능하다!
                                    .param("amount",String.valueOf(amount)))
                                                                .andExpect(status().isOk())
                                                                .andExpect(jsonPath("$.name", is(name)))        // jsonPath : JSON 응답값을 필드별로 검증할수 있는 메소드
                                                                                                                                    // $를 기준으로 필드명을 명시합니다.
                                                                                                                                    // 여기선 name & amount를 검증하니까 저렇게 사용
                                                                .andExpect(jsonPath("$.amount", is(amount)));
    }


}
