package com.templar.javatraining.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@Component
@ToString
public class Student {

    private int id;

    private String name;

}
