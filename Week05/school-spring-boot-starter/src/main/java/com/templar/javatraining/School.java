package com.templar.javatraining;

import com.templar.javatraining.bean.Klass;
import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@AllArgsConstructor
@ToString
@ConfigurationProperties(prefix = "school")
@PropertySource({"classpath:application.yml"})
@ConditionalOnProperty(
        prefix = "school",
        name = "enabled",
        havingValue = "true")
public class School {

    private List<Klass> klassList;

}
