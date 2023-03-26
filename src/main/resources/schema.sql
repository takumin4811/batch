create table if not exists JOBPARAMHISTORY(
    id INT  AUTO_INCREMENT primary key,
    jobid varchar(10)  ,
    jobname varchar(50),
    update_at TIMESTAMP 
);
