package com.example.webbatch.hello2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webbatch.hello.entity.FlowContext;

@Service
public class SimeSijiFileRead {
    @Autowired
    FlowContext flowContext;

    public void readSimeSijiFile() {
        //モック処理（実際はファイルから読取ってFlowContextの各フィールド値をセットする）
        flowContext.setCourseCd("コースコードA");
        flowContext.setSimeSyriKjnYmd(20231231);
    }
}
