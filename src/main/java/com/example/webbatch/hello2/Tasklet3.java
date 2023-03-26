package com.example.webbatch.hello2;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

@Component
@StepScope
 //SetepScopeにすることでステップごとにインスタンス生成される 
public class Tasklet3 extends BaseTasklet {

    @Override
    protected void execute() {
        System.out.println("do at " + this.getClass().toString());
        jobExecutionContext.put("testTasklet", "testValue");
    }

}
