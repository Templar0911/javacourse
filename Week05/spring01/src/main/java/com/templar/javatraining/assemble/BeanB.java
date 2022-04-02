package com.templar.javatraining.assemble;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class BeanB {

    @Value("2")
    private int id;

    @Value("beanB123")
    private String name;

}
