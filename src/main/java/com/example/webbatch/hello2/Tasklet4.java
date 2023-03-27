package com.example.webbatch.hello2;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@StepScope
@Slf4j
//SetepScopeにすることでステップごとにインスタンス生成される 
public class Tasklet4  extends BaseTasklet {
  Integer status=0;

  @Override
  protected void execute() {
      log.info("do at " + this.getClass().toString());
      String value = jobExecutionContext.getString("testTasklet");
      log.info("testValue==" + value+    status++);
      log.info("コースコード＝＝＞ " + super.flowContext.getCourseCd());
      log.info("コースコード＝＝＞ " + flowContext.getCourseCd());
      log.info("アップデート時刻＝＝＞ " + flowContext.getUpdateTime());
    }

}