package com.example.webbatch.hello2;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webbatch.hello.entity.FlowContext;

import lombok.extern.slf4j.Slf4j;

@Component
@JobScope
@Slf4j
public class JobListener implements JobExecutionListener{
    @Autowired
    SimeSijiFileRead simeSijiFileRead;

    @Autowired
    FlowContext flowContext;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("==============beforeJOB--" + jobExecution);

        // JOBPARAMEERSはJOB実行コンテキストに格納されている
        log.info("JobParameters -->  "+jobExecution.getJobParameters());

        //締め指示ファイルの読み込みとJOB実行コンテキスト（＠JobScope）への取り込み（JOB実行終了まで保持される）
        // 締め指示ファイルの読み込みに必要な情報（ファイルパスなど）があれば、それはリクエスト要求ー＞JOBPARAMETRSから取得する）
        flowContext = simeSijiFileRead.readSimeSijiFile();
        ExecutionContext jectx = jobExecution.getExecutionContext();
        jectx.put("FlowContext", flowContext);

        log.info("==============beforeJOB--" + jobExecution);
        log.info("==============beforeJOB--" + jobExecution.getExecutionContext().get("FlowContext"));

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("==============afterJOB--" + jobExecution);
    }
    
}
