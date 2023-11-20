package com.example.demo;

import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Register {

  @RequestMapping("/")
  public String start() {
    return "input.html";
  }

  @RequestMapping("/register")
  public ModelAndView register(@ModelAttribute RegisterBean rb, ModelAndView m) {
    m.addObject("rb", rb);

    // 4通りの運勢を用意
    String[] fortunes = { "大吉", "中吉", "小吉", "凶" };

    // ランダムに運勢を選択
    Random random = new Random();
    int index = random.nextInt(fortunes.length);
    String selectedFortune = fortunes[index];

    // ModelAndViewに運勢をセット
    m.addObject("fortune", selectedFortune);

    m.setViewName("register.html");
    return m;
  }
}
