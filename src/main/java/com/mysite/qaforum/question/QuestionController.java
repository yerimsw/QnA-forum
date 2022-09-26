package com.mysite.qaforum.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor // final 키워드가 붙은 질문 리포지토리를 초기화하는 생성자를 만든다.
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list"; // 질문목록 나타내기 위해
    }

    @RequestMapping("/list") // localhost:8080/question/list url에 매핑되는 컨트롤러
    public String list(Model model){
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList",questionList);
        // Model 객체에 리스트 객체를 저장한다.
        // 컨트롤러가 리턴하는 question_list.html에서 "questionList" 이름으로 questionList 리스트 객체를 사용할 수 있다.
        return "question_list";
    }

    @RequestMapping("/detail/{question_id}")
    public String detail(Model model, @PathVariable("question_id")Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        // question_detail.html에 question이라는 이름으로 데이터를 전달한다.
        // 서비스객체에서 id로 Question 객체를 찾아 반환하는 getQuestion(id)메서드를 사용한다.
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    } // 질문등록 버튼을 누르면 질문등록 페이지로 넘겨준다.

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        // HTML에서 subject와 content 데이터가 담긴 form이 전송되면 QuestionForm의 subject와 content가 자동으로 바인딩 된다.
        if(bindingResult.hasErrors()) return "question_form"; // @Valid로 검증을 수행하여, 오류가 있는 경우 질문 등록 화면으로 돌아온다.
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list"; // 질문 등록 완료 후 목록페이지로 리턴
    }
}
