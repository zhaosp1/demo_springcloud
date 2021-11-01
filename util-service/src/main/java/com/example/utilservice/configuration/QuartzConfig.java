package com.example.utilservice.configuration;


import com.example.utilservice.service.MyJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz配置类
 * 一点教程网 - www.yiidian.com
 */
@Configuration
public class QuartzConfig {

  @Bean
  public MyJob createJob(){
    return new MyJob();
  }

  /**
   * 创建任务
   */
  @Bean
  public MethodInvokingJobDetailFactoryBean jobDetailFactoryBean(MyJob job){
    MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
    //设置任务对象
    factoryBean.setTargetObject(job);
    //设置任务方法
    factoryBean.setTargetMethod("task");
    return factoryBean;
  }

  /**
   * 触发器
   */
  @Bean
  public CronTriggerFactoryBean createTrigger(MethodInvokingJobDetailFactoryBean jobDetailFactoryBean){
    CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
    triggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
    triggerFactoryBean.setCronExpression("0/10 * * * * ? *");
    return triggerFactoryBean;
  }

  /**
   * 创建Schduler
   */
  @Bean
  public SchedulerFactoryBean getSchedulerFactoryBean(CronTriggerFactoryBean triggerFactoryBean){
    SchedulerFactoryBean factory = new SchedulerFactoryBean();
    //关联trigger
    factory.setTriggers(triggerFactoryBean.getObject());
    return factory;
  }
}