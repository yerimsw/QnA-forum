package com.mysite.qaforum.question;

import com.mysite.qaforum.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    } // 질문 목록을 가져오는 메서드

    public Question getQuestion(Integer id){ // id속성으로 Question 찾는 메서드
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) return question.get(); // Optional에서는 get으로 Question객체를 얻음
        else throw new DataNotFoundException("question not found");
    }

    public void create(String subject, String content){ // 질문을 등록하는 메서드
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }
}
