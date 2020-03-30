package com.myspring.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {   // 보통 Dao라고 불리는 DB Layer 접근자. JPA 에선 Repository라고 부르며 인터페이스로 생성한다.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")  //SpringDataJpa 에서 제공하지 않는 메소드는 이렇게 쿼리로 작성하면 된다.    // 복잡한 쿼리는 querydsl,mybatis 등으로 사용
    List<Posts> findAllDesc();
}
