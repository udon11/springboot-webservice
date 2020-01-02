package com.myspring.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;   // 스태틱으로 추가

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then

        assertThat(dto.getName()).isEqualTo(name);      //assertj라는 테스트 검증 라이브러리의 검증 메소드이다. //검증하고싶은 대상을 메소드인자로 받습니다.
                                                        //메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용가능
        assertThat(dto.getAmount()).isEqualTo(amount);  //"isEqualTo" assertj의 동등비교 메소드 //assertThat에있는 값과 isEqualTo의 값을 비교해서 같을때만 성공.
    }
}
