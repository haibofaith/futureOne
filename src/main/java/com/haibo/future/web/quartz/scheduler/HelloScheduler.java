package com.haibo.future.web.quartz.scheduler;

import com.haibo.future.web.quartz.jobs.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:haibo.xiong
 * @date:2018/12/4
 * @description:
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //1、创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob","group1").build();
        //2、创建Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","triGroup1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        //3、创建scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        System.out.println("Current time is:"+currentTime);
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
