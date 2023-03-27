package com.example.webbatch.hello2;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("tasklet0")
@StepScope 
@Slf4j
public class Tasklet0 extends BaseTasklet {

    @Override
    protected void execute() {
        System.out.println("do at " + this.getClass().toString());
        log.info("★★★★★FlowContext"+super.flowContext.toString());
    }
}

