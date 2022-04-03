package com.templar.javatraining.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ToString
public class Klass {

    private List<Student> studentList;

}
