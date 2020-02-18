package com.kostars.newtroshop.web;

import com.kostars.newtroshop.config.auth.LoginUser;
import com.kostars.newtroshop.config.auth.dto.SessionUser;
import com.kostars.newtroshop.domain.cart.ShoppingCart;
import com.kostars.newtroshop.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/checkout")
    public String checkout(Model model, @LoginUser SessionUser user) {
        model.addAttribute("user", user);
        return "checkout";
    }

    @GetMapping("/payment")
    public String payment(Model model, @LoginUser SessionUser user, ShoppingCart cart) {
        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "payment";
    }
}
