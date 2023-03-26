package com.example.webbatch.hello2;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

@Component
@StepScope

//SetepScopeにすることでステップごとにインスタンス生成される 
public class Tasklet4  extends BaseTasklet {
  Integer status=0;

  @Override
  protected void execute() {
      System.out.println("do at " + this.getClass().toString());
      String value = jobExecutionContext.getString("testTasklet");
      System.out.println("testValue==" + value+    status++);
      System.out.println(super.getCourseCd());
  }

}