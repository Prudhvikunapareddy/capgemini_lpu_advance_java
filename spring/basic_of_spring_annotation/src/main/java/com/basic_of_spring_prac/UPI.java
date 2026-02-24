package com.basic_of_spring_prac;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Component
@Primary
public class UPI implements Payment {
    public void send() {
        System.out.println("Money sent using UPI");
    }
}