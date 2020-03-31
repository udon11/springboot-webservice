package com.myspring.book.springboot.web.dto;

import com.myspring.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter // getter 없어서 p.118 실패했었음
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
