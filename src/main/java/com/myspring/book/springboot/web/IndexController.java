package com.myspring.book.springboot.web;

import com.myspring.book.springboot.config.auth.LoginUser;
import com.myspring.book.springboot.config.auth.dto.SessionUser;
import com.myspring.book.springboot.domain.user.User;
import com.myspring.book.springboot.service.PostsService;
import com.myspring.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){   //Model 서버템플릿엔진에서 사용할수있는 객체를 저장할수있다.
        model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");    // @LoginUser로 개선
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    /*
    @GetMapping("/")
    public String index(){
        return "index";
    }
    */
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
