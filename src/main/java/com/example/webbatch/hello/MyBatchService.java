package com.example.webbatch.hello;
import java.util.Date;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webbatch.dao.JobParamHistoryMapper;
import com.example.webbatch.hello.entity.Jobparams;

@Component
@StepScope
public class MyBatchService {
    Integer aaa=0;
    @Autowired
    JobParamHistoryMapper jobParamHistoryMapper;

    public void execute(String jobid, String jobname, Date reqDate) throws InterruptedException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        // 適当なバッチ処理
        Thread.sleep(2000);
        aaa=aaa+10;
        System.out.println("★★★★★★　　JOBを開始しました　　　　★★★★★    "+aaa);

        jobParamHistoryMapper.add(new Jobparams(jobid,jobname));
        System.out.println(jobParamHistoryMapper.findall().toString());
    }
}













