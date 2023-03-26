package com.example.webbatch.hello2;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;


@Component
@StepScope
public class Tasklet2 implements Tasklet {
 Integer status=0;
  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {
    status++;
    System.out.println("Tasklet2 が実行されました。status="+status);
    return RepeatStatus.FINISHED;
  }

}