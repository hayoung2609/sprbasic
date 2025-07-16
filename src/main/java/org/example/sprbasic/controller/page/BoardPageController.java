package org.example.sprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller // 중요한 개념일수록 아래에 적는 스타일
public class BoardPageController {

    /*
    @RequestMapping("/create")
    public String create(){
        return "board/create";
    }
    */

    // 위의 코드에서 여러 경로를 한 번에 처리할 수 있게 코딩
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/" + page;
    }
}


