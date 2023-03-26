package com.example.webbatch.hello2;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@StepScope
@Component
@Inherited
public @interface TstarStepScope {

}