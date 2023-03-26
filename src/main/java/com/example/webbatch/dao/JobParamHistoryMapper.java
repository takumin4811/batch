package com.example.webbatch.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.webbatch.hello.entity.Jobparams;
import com.example.webbatch.hello.entity.Jobhistory;

import java.util.List;

@Mapper
public interface JobParamHistoryMapper {

    @Select("SELECT JOBID,JOBNAME FROM JOBPARAMHISTORY WHERE jobid = #{jobid}")
    Jobparams find(String jobid);
    @Select("SELECT id,jobid,jobname,update_at FROM JOBPARAMHISTORY")
    List<Jobhistory> findall();
    @Insert("insert into JOBPARAMHISTORY(jobid,jobname,update_at) values (#{jobid},#{jobname},CURRENT_TIMESTAMP)")
    void add(Jobparams jobparams);
}














