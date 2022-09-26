package com.mysite.qaforum.question;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message="제목은 필수항목입니다.") // 문자열 null 또는 ""을 허용하지 않는다.
    @Size(max=200) // 최대 문자열 길이가 200을 넘을 수 없다.
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}
