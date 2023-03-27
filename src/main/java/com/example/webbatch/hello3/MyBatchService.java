package com.example.webbatch.hello3;
import java.util.Date;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webbatch.hello.entity.Jobparams;
import com.example.webbatch.hello3.dao.JobParamHistoryMapper;
import com.example.webbatch.hello.entity.FlowContext;
import com.example.webbatch.hello2.SimeSijiFileRead;

@Component
public class MyBatchService {
    Integer aaa=0;
    @Autowired
    JobParamHistoryMapper jobParamHistoryMapper;
    @Autowired
    private SimeSijiFileRead simeSijiFileRead;
    @Autowired
    FlowContext flowContext;

    public void execute(String jobid, String jobname, Date reqDate) throws InterruptedException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        simeSijiFileRead.readSimeSijiFile();

        Thread.sleep(2000);
        aaa=aaa+10;
        System.out.println("★★★★★★　　JOBを開始しました　　　　★★★★★    "+aaa);

        jobParamHistoryMapper.add(new Jobparams(jobid,jobname));
        System.out.println(jobParamHistoryMapper.findall().toString());

    }
}













