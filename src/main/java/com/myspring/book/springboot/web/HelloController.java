package com.myspring.book.springboot.web;

import com.myspring.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //p.60
public class HelloController {

    @GetMapping("/hello") // get 요청을 받을수있는 api를 만들어 준다  //예전에는 @RequestMapping(method = RequestMethod.GET)으로 사용
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return  new HelloResponseDto(name,amount);
    }
}
