package com.example.webbatch.hello2;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.webbatch.hello.entity.FlowContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseTasklet extends KytInfoGetBase
        implements Tasklet, StepExecutionListener  {

    protected ExecutionContext jobExecutionContext;
    @Autowired
    FlowContext flowContext;

    @Override
    public void beforeStep(StepExecution stepJikkouInfo) {
        this.jobExecutionContext = stepJikkouInfo.getJobExecution().getExecutionContext();
        ExecutionContext stepExecutionContext = stepJikkouInfo.getExecutionContext();
        stepExecutionContext.put("READ_TOTAL_COUNT", -1);

        // flowContext=(FlowContext) stepJikkouInfo.getJobExecution().getExecutionContext().get("FlowContext");
        // log.info("FlowContext--->"+flowContext);
        // flowContext = (FlowContext) stepJikkouInfo.getJobExecution().getExecutionContext().get("FlowContext");
        // setFlowContext(flowContext);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepJikkouInfo) {
        return stepJikkouInfo.getExitStatus();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkCtxt) throws Exception {
        execute();
        return RepeatStatus.FINISHED;

    }

    protected abstract void execute();

}
