package com.example.webbatch.hello2;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@JobScope
@Slf4j
//SetepScopeにすることでステップごとにインスタンス生成される 
public class Tasklet4  extends BaseTasklet {
  Integer status=0;

  @Override
  protected void execute() {
      log.info("do at " + this.getClass().toString());
      String value = jobExecutionContext.getString("testTasklet");
      log.info("testValue==" + value+    status++);
      // log.info(super.getCourseCd());
  }

}