package com.myspring.book.springboot.domain.user;

import com.myspring.book.springboot.domain.posts.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)    //jpa로 데이터베이스로 저장할때 Enum값을 어떤 형태로 저장할지를 결정
                                    // 기본적으로는 int로 된 숫자가 저장된다.
                                    //  하지만 숫자로 저장되면 db로 확인할때 그값이 무슨코드 의미하는지 모름 그래서 문자열로 저장될수있게 선언
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
