package org.example.sprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링부트 bin 등록.
public class DefaultPageController {

    /*
    @RequestMapping("")
    public String index() { // String은 리턴값으로 string만 반환
        return "index";
    }
    @RequestMapping("/")
    public String index2() { // String은 리턴값으로 string만 반환
        return "index";
    }
    @RequestMapping("/index")
    public String index3() { // String은 리턴값으로 string만 반환
        return "index";
    }
    */
    // RequestMapping 안에 주소 값은 배열도 가능
    @RequestMapping({"", "/", "/index"})
    public String index() { // String은 리턴값으로 string만 반환
        return "index";
    }

    // 두 개의 숫자를 입력받아, 더해주는 페이지 컨트롤러 만들기
    // 더한 결과를 모델에 담아서, 페이지에서 값을 확인하도록 한다.
    @RequestMapping("/calculate2")
    public String calculate2(int num1, int num2, Model model){
        int sum = num1 + num2;
        model.addAttribute("result", sum);
        /*
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("sum", sum);
        temp.put("code", "success");
        model.addAttribute("result", temp);
        */
        return "calculate"; // Thymeleaf HTML 파일의 이름 반환
    }

    @RequestMapping("/calculate3")
    public String calculate3(int num1, int num2, Model model){
        int mul = num1 * num2;
        model.addAttribute("result", mul);
        /*
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("sum", sum);
        temp.put("code", "success");
        model.addAttribute("result", temp);
        */
        return "calculate"; // Thymeleaf HTML 파일의 이름 반환
    }

    /*
    @RequestMapping("/sum")
    public String sum(@RequestParam double a, @RequestParam double b, Model model) {
        // RequestParam은 Null값을 받았을 때 에러남.
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        double result = a + b;
        System.out.println("a + b = " + result);

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("sum", result);

        return "sum"; // Thymeleaf HTML 파일의 이름 반환
    }

    @RequestMapping("/sum2")
    public String sum(String a, String b, Model model) {
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        int int_a = Integer.parseInt(a);
        int int_b = Integer.parseInt(b);
        int sum = int_a + int_b;

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("sum", sum);
        return "sum"; // Thymeleaf HTML 파일의 이름 반환
    }
    */

}
