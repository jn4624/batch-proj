package com.app.batch.config;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableBatchProcessing
 * Spring Batch 기능을 활성화하고 배치 작업을 설정하기 위한 기본 구성을 제공한다.
 * JobRepository, JobLauncher, JobRegistry, PlatformTransactionManager, JobBuilderFactory, StepBuilderFactory 를 빈으로 제공한다.
 * https://docs.spring.io/spring-batch/docs/current/api/org/springframework/batch/core/configuration/annotation/EnableBatchProcessing.html
 */
@EnableBatchProcessing
@Configuration
public class BatchConfig {
    /**
     * JobRegistry 는 context 에서 Job을 추적할 때 유용하다.
     * JobRegistryBeanPostProcessor 는 Application Context 가 올라가면서 bean 등록 시, 자동으로 JobRegistry 에 Job을 등록 시킨다.
     *
     * JobRegistry 관련된 설정 추가
     * - JobRegistryBeanPostProcessor 를 등록해줘야 JobRegistry 에서 Job 을 뽑아 쓸 수 있다.
     * - 만약에 이 부분이 선언되지 않는다면 Job 을 찾을 수 없다는 에러가 발생한다.
     * - JobRegistry 외에 설정해야 하는 부분은 application.yml 파일이다.
     */
    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
        return jobRegistryBeanPostProcessor;
    }
}
