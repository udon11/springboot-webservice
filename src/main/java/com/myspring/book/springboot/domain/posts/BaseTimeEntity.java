package com.myspring.book.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JAP Entity클래스들이 해당 클래스를 상속할경우 필드들 도 칼럼으로 인식하게함
@EntityListeners(AuditingEntityListener.class)  // 해당 클래스에 Auditing 기능을 포함시킨다
public class BaseTimeEntity {

    @CreatedDate    // Entity가 생성되어 저장될때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity의 값을 변경할때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
