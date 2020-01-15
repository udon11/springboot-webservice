package com.myspring.book.springboot.domain.posts;


import com.myspring.book.springboot.service.PostsService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정없이 @SpringBootTest를 사용할 경우에 H2데이터베이스를 자동으로 실행해준다.
public class PostsRepositoryTest {  // save, findAll 기능을 테스트한다.

    @Autowired
    PostsRepository postsRepository;

    @After  // junit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
                // 보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
                // 여러 테스트 실행하면 테스트데이터베이스인 h2에 데이터가 남아있을수도 있어서 다음테스트 실패 할수도 있기 때문에
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // postsRepository.save : 테이블 posts에 insert/update퀘리를 실행한다.
            // id값이 있으면 update가, 없다면 insert쿼리가 실행 (marge into 기능이랑 비슷한듯?)
        postsRepository.save(Posts.builder()
                                            .title(title)
                                            .content(content)
                                            .author("tlqkspt@gmail.com")
                                            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();  // postsRepository.findAll : 테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
       //given
       LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
       postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

       //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
