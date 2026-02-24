package com.basic_of_spring_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	@Value("123456")
private String number;
}
