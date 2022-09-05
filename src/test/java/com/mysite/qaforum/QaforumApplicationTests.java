package com.mysite.qaforum;

import com.mysite.qaforum.question.Question;
import com.mysite.qaforum.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class QaforumApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJPA() {
		Question q1 = new Question();
		q1.setSubject("첫 번째 질문입니다.");
		q1.setContent("첫 번째 질문의 내용입니다: Question, Answer과 같이 데이터를 관리할 수 있는 클래스, 테이블과 매핑되는 클래스를 엔티티라고 하나요?");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // JPA에서 이미 구현된 메서드 save다.

		Question q2 = new Question();
		q2.setSubject("두 번째 질문입니다.");
		q2.setContent("두 번째 질문의 내용입니다: questionRepository 객체를 new연산자를 통해 직접 생성하지 않아도 스프링이 알아서 생성해주는 건가요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}
}
