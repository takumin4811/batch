package com.example.webbatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;

import com.example.webbatch.hello.entity.FlowContext;
import com.example.webbatch.hello2.Tasklet1;
import com.example.webbatch.hello2.Tasklet2;
import com.example.webbatch.hello2.Tasklet3;
import com.example.webbatch.hello2.Tasklet4;

@Configuration
@EnableBatchProcessing //(1)
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory; //(2)
    @Autowired
    private StepBuilderFactory stepBuilderFactory; //(2)
    @Autowired
    FlowContext flowContext;
    @Autowired
    JobExecutionListener jobExecutionListener;

    @Bean
    public JobLauncher jobLauncher1(JobRepository jobRepository) { //(2),(3)
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 同時実行数は3.それ以上はキュー待ちになる.
        taskExecutor.setCorePoolSize(3); //(4)
        taskExecutor.initialize(); //(5)
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(taskExecutor);
        return jobLauncher;
    }
    
  
    // 初期化ステップ(相当）
    @Bean("step0")
    public Step step0(@Qualifier("tasklet0") Tasklet tasklet0) { //(6)
      return stepBuilderFactory.get("step0")
                    .tasklet(tasklet0)
                    .build();
    }



    // 後続JOB1
    @Bean("Job-Layer1A")
    public Job jobLayer1A(Tasklet1 tasklet1, Tasklet2 tasklet2) {					
      TaskletStep step1 = stepBuilderFactory.get("step1").tasklet(tasklet1).build();								
      TaskletStep step2 = stepBuilderFactory.get("step2").tasklet(tasklet2).build();					

      return jobBuilderFactory.get("Job-Layer1A").incrementer(new RunIdIncrementer())
      .start(step1).next(step2)
      .listener(jobExecutionListener)
      .build();		
    }

    // 後続JOB2
    @Bean("Job-Layer1B")			
        public Job jobLayer1B(Tasklet3 tasklet3, Tasklet4 tasklet4) {					
				TaskletStep step3 = stepBuilderFactory.get("step3").tasklet(tasklet3).build();								
        TaskletStep step4 = stepBuilderFactory.get("step4").tasklet(tasklet4).build();					

        return jobBuilderFactory.get("Job-Layer1B").incrementer(new RunIdIncrementer())
        .start(step3).next(step4)
        .listener(jobExecutionListener)
        .build();		
    }					


    // 初期化ステップと後続JOBをまとめたフロー
    @Bean
    public Flow flow(Step step0,@Qualifier("Job-Layer1A") Job job1,@Qualifier("Job-Layer1B") Job job2) {
    Step jobstep1 =stepBuilderFactory.get("step-name").job(job1).build();
    Step jobstep2 =stepBuilderFactory.get("step-name").job(job2).build();
    return new FlowBuilder<Flow>("flow")
      .from(step0)
      .next(jobstep1)
      .next(jobstep2)
      .build(); 
    }

    // 初期化ステップと後続JOBをまとめたFlowを引数にしたジョブを定義
    @Bean("Job-Layer0")
    public Job job0(Flow flow) { 
        return jobBuilderFactory.get("Job-Layer0")
                    .incrementer(new RunIdIncrementer())
                    .start(flow).end()
                    .listener(jobExecutionListener)
                    .build();
    }    


}


