package com.example.webbatch.hello2;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

public abstract class BaseTasklet extends KytInfoGetBase implements Tasklet, StepExecutionListener {
        protected ExecutionContext jobExecutionContext;

        @Override
        public void beforeStep(StepExecution stepJikkouInfo) {
        // public final void beforeStep(StepExecution stepJikkouInfo) {
            this.jobExecutionContext = stepJikkouInfo.getJobExecution().getExecutionContext();
            ExecutionContext stepExecutionContext = stepJikkouInfo.getExecutionContext();
            stepExecutionContext.put("READ_TOTAL_COUNT", -1);
        }
    
        @Override
        public ExitStatus afterStep(StepExecution stepJikkouInfo) {
            
            // ステップ終了ステータス返却
            return stepJikkouInfo.getExitStatus();
        }
    
        @Override
        public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkCtxt) throws Exception {
            execute();

            return RepeatStatus.FINISHED;

        }
    
        protected abstract void execute();
    
}
