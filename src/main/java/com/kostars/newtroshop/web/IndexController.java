package com.kostars.newtroshop.web;

import com.kostars.newtroshop.config.auth.LoginUser;
import com.kostars.newtroshop.config.auth.dto.SessionUser;
import com.kostars.newtroshop.domain.user.User;
import com.kostars.newtroshop.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/loginpage")
    public String loginpage() {

        return "loginpage";
    }

    @GetMapping("user/mypage")
    public String mypage(Model model, @LoginUser SessionUser user) {
        model.addAttribute("user", user);
        return "mypage";
    }

}
