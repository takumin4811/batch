package com.example.webbatch.hello2;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.webbatch.hello.entity.FlowContext;

public class KytInfoGetBase {
    @Autowired
    private FlowContext flowContext;

    public String getCourseCd() {
        return flowContext.getCourseCd();
    }

    public Integer getSimeSyriKjnYmd() {
        return flowContext.getSimeSyriKjnYmd();
    }

}
