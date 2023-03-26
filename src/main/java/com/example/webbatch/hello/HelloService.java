package com.example.webbatch.hello;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@Getter
@NoArgsConstructor
public class HelloService {

  private int value = 0;

  public int getValue() {
    return value++; // 値を返してからインクリメント
  }
}
