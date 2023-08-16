package com.app.batch.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;

import java.util.Properties;

@Getter
@Setter
@ToString
public class JobLauncherRequest {
    private String name; // job 이름
    private Properties jobParameters; // job 파라미터

    public JobParameters getJobParameters() {
        return new JobParametersBuilder(this.jobParameters).toJobParameters();
    }
}
