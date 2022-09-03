package com.mysite.qaforum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloLombok2 {
    private final String hello2;
    private final int num2;

    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok("헬로2",5);
        System.out.println(helloLombok.getHello2());
        System.out.println(helloLombok.getNum2());
    }
}
