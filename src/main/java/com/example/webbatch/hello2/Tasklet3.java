package com.example.webbatch.hello2;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@StepScope
@Slf4j
public class Tasklet3 extends BaseTasklet {

    @Override
    protected void execute() {
        log.info("do at " + this.getClass().toString());
        jobExecutionContext.put("testTasklet", "testValue");
    }

}
