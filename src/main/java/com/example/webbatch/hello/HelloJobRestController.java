package com.example.webbatch.hello;

import java.util.Calendar;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.webbatch.hello.entity.Jobparams;

import org.springframework.batch.core.JobExecution;

@RestController
public class HelloJobRestController {
    @Autowired
    private JobLauncher jobLauncher1;

    @Autowired
    @Qualifier("Job-Layer0")
    private Job job;

    @Autowired
    private JobExplorer jobExplorer;


    @RequestMapping(value= "/hello/api/job" ,method=RequestMethod.POST)
    public long startJob(@RequestBody Jobparams jobparms ) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {
   
        JobParameters params = new JobParametersBuilder()
        // .addString("DD_USER", jobparms.DD_USER)
        // .addString("DD_EXECID", jobparms.DD_EXECID)
        // .addString("DD_KJN", jobparms.DD_KJN)
        // .addString("DD_KIDOUID", jobparms.DD_KIDOUID)
        .addString("jobid", jobparms.getJobid())        
        .addString("jobname", jobparms.getJobname())
        .addDate("reqDate", Calendar.getInstance().getTime())
        .toJobParameters();
        JobExecution jobstatus=jobLauncher1.run(job, params);
        return jobstatus.getId();
    }

    @RequestMapping(value= "/hello/api/job/{id}" ,method=RequestMethod.GET)
    public BatchStatus getJobstatus(@PathVariable long id ) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {

        JobExecution jobExecution= jobExplorer.getJobExecution(id);
        return jobExecution.getStatus();
    }
    @RequestMapping(value= "/hello/api/job/details/{id}" ,method=RequestMethod.GET)
    public String getJobDetailstatus(@PathVariable long id ) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {

        JobExecution jobExecution= jobExplorer.getJobExecution(id);
        return jobExecution.toString();
    }

}


