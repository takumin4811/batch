package com.example.webbatch.hello.entity;


import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@JobScope
public class FlowContext {
    private String courseCd;
    private Integer simeSyriKjnYmd;
}
