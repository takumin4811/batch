package com.example.webbatch.hello2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.example.webbatch.hello.entity.FlowContext;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KytInfoGetBase {

    @Autowired
    FlowContext flowContext;


    public String getCourseCd() {
        return flowContext.getCourseCd();
    }

    public Integer getSimeSyriKjnYmd() {
        return flowContext.getSimeSyriKjnYmd();
    }

}
