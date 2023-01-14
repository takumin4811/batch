package com.example2.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



// ジョブとステップの作成にはJobBuilderFactoryとStepBuilderFactoryが必要で、これらは
// @EnableBatchProcessingを付与すると@Autowiredで取得できるようになります

@Component
@EnableBatchProcessing
public class SampleJobConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  
//tasklet1を引数に、実行可能なStep型（ジョブの最小実行単位）のオブジェクトを取得、Bean登録（オブジェクトは＠BeanによりSpringがインジェクションしてくれBean登録される）
  @Bean
  public Step step1(Tasklet tasklet1) {
    return stepBuilderFactory.get("step1").tasklet(tasklet1).build();
  }

  @Bean
  public Step step2(Tasklet tasklet2) {
    return stepBuilderFactory.get("step2").tasklet(tasklet2).build();
  }

//複数のステップをまとめたJOB型のオブジェクトを取得、Bean登録
@Bean
  public Job sampleJob(Step step1, Step step2) {
    return jobBuilderFactory.get("sampleJob").start(step1).next(step2).build();
  }

}