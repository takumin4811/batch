package com.example.webbatch.hello2;

import org.springframework.stereotype.Service;

import com.example.webbatch.hello.entity.FlowContext;

@Service
public class SimeSijiFileRead {
    public FlowContext readSimeSijiFile() {
        //モック処理（実際はファイルから読取ってFlowContextの各フィールド値をセットする）
        return new FlowContext("コースコードA",20500923);
    }
}
