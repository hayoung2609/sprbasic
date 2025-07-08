package org.example.sprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostPageController {

    @GetMapping("/{page}") // requestmapping에서 메서드 지정
    public String create(@PathVariable String page) {
        return "post/" + page;
    }
}
