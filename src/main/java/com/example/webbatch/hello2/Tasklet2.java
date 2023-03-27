package com.example.webbatch.hello2;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webbatch.hello3.HelloService;

import lombok.extern.slf4j.Slf4j;



@Component
@StepScope
@Slf4j
public class Tasklet2 extends BaseTasklet {
 Integer status=0;
@Autowired
HelloService helloService;

 @Override
 protected void execute() {
   status++;
   log.info("Tasklet2 が実行されました。status=" + status + "hello---" + helloService.getValue());
   log.info("do at " + this.getClass().toString());
   log.info(("コースコード＝＝＞ " + super.getCourseCd()));
 }
}
