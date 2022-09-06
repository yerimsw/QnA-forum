package com.mysite.qaforum.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor // final 키워드가 붙은 질문 리포지토리를 초기화하는 생성자를 만든다.
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list"; // 질문목록 나타내기 위해
    }

    @RequestMapping("/question/list") // localhost:8080/question/list url에 매핑되는 컨트롤러
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);
        // Model 객체에 리스트 객체를 저장한다.
        // 컨트롤러가 리턴하는 question_list.html에서 "questionList" 이름으로 questionList 리스트 객체를 사용할 수 있다.
        return "question_list";
    }

    @RequestMapping("/question/detail/{question_id}")
    public String detail(Model model, @PathVariable("question_id")Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        // question_detail.html에 question이라는 이름으로 데이터를 전달한다.
        // 서비스객체에서 id로 Question 객체를 찾아 반환하는 getQuestion(id)메서드를 사용한다.
        return "question_detail";
    }
}
