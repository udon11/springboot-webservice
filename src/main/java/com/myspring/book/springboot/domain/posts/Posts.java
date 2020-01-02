package com.myspring.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동추가
@Entity // 테이블과 링크될 클래스임을 나타낸다.
            //기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
            // ex)SalesManager.java -> sales_manager table
public class Posts {    //실제 db테이블과 연결될 클래스 Entity클래스 라고도 한다.

    @Id //해당 테이블의 pk필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //pk의 생성규칙을 나타낸다
                                                                // 스프링 부트 2.0부터는 GenerationTypoe.IDENTITY 옵션을 추가해야 auto_increment가된다
                                                                // 2.0과 1.5버전의 차이 https://jojoldu.tistory.com/295 에 정리
    private Long id;

    @Column(length = 500, nullable = false)     // 테이블 칼럼을 나타낸다. 굳이 선언하지 않아도 해당클래스의 필드는 모두 칼럼이된다.
                                                    // 사용이유? 기본값 외에 추가로 변경 필요한 옵션있을때 사용
                                                    // 문자열 기본값 VARCHAR(255), 사이즈를 500으로 늘리고싶거나, 타입을 TEXT로 변경하고 싶을 경우에 사용(ex:content)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성
                    // 생성자 상단에 선언 시 생성자에 포함된 빌드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
