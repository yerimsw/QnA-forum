package com.mysite.qaforum.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor // final 키워드가 붙은 질문 리포지토리를 초기화하는 생성자를 만든다.
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @RequestMapping("/question/list") // localhost:8080/question/list url에 매핑되는 컨트롤러
    public String list(Model model){
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList",questionList);
        // Model 객체에 리스트 객체를 저장한다.
        // 컨트롤러가 리턴하는 question_list.html에서 "questionList" 이름으로 questionList 리스트 객체를 사용할 수 있다.
        return "question_list";
    }
}
