package com.example.webbatch.hello2;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("tasklet0")
@JobScope 
@Slf4j
public class Tasklet0 extends BaseTasklet {

    @Override
    protected void execute() {
        System.out.println("do at " + this.getClass().toString());
        log.info(super.flowContext.toString());
    }
}

