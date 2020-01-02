package com.myspring.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {   // 보통 Dao라고 불리는 DB Layer 접근자. JPA 에선 Repository라고 부르며 인터페이스로 생성한다.
}
