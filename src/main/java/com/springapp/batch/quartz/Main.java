package com.springapp.batch.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-28
 * Time: 下午3:22
 */
public class Main {
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    public static void main(String[] args) {
        String springConfig  = "quartzjob/job-quartz.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
//        String jobDate = "";
//        Calendar currentTime = Calendar.getInstance();
//        System.out.println(sdf.format(currentTime.getTime()));
//        currentTime.add(Calendar.DAY_OF_MONTH, -1);
//        jobDate = sdf.format(currentTime.getTime());
//        System.out.println(jobDate);
    }
}
