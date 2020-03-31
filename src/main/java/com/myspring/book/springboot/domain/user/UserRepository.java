package com.myspring.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);   // email을 통해서 이미생성된 사용자인지 처음가입하는 사용자인지 판단
}
