package com.example.webbatch.hello2;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webbatch.hello3.HelloService;


 //SetepScopeにすることでステップごとにインスタンス生成される 
@Component
@StepScope
public class Tasklet1 implements Tasklet {

  //マルチスレッド対応できているかのチェック用インスタンス変数
  Integer status=0;

  @Autowired
  HelloService helloService;

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    status++;
    System.out.println("Tasklet1 が実行されました。status="+status+"    hello---"+helloService.getValue());
    return RepeatStatus.FINISHED;
  }

}