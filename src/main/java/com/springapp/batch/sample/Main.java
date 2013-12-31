package com.springapp.batch.sample;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-27
 * Time: 下午1:13
 */
public class Main {

    public static final String RUN_MONTH_KEY = "run.month";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("message_job.xml");
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository((JobRepository)c.getBean("jobRepository"));
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        try{
            Map<String,JobParameter> parameters = new HashMap<String, JobParameter>();
            parameters.put(RUN_MONTH_KEY,new JobParameter("2011-10"));
            JobExecution je = launcher.run((Job) c.getBean("messageJob"), new JobParameters(parameters));
//            parameters.put(RUN_MONTH_KEY,new JobParameter("2011-11"));
            TimeUnit.SECONDS.sleep(10);
            launcher.run((Job)c.getBean("messageJob"), new JobParameters(parameters));
            System.out.println(je);
            System.out.println(je.getJobInstance());
            System.out.println(je.getStepExecutions());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
