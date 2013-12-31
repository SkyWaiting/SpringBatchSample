package com.springapp.batch.quartz.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: guorui
 * Date: 13-12-28
 * Time: 上午9:40
 */
public class JobLauncherDetails extends QuartzJobBean{

    static final String JOB_NAME = "jobName";

    private JobLocator jobLocator;

    private JobLauncher jobLauncher;

    public void setJobLocator(JobLocator jobLocator) {
        this.jobLocator = jobLocator;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Map<String,Object> jobDataMap = jobExecutionContext.getMergedJobDataMap();

        String jobName = (String)jobDataMap.get(JOB_NAME);

        JobParameters jobParameters = getJobParametersFromJobMap(jobDataMap);

        try {
            jobLauncher.run(jobLocator.getJob(jobName), jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (NoSuchJobException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get params from jobDataAsMap property.
     * @param jobDataMap
     * @return
     */
    private JobParameters getJobParametersFromJobMap(Map<String,Object> jobDataMap){

        JobParametersBuilder builder = new JobParametersBuilder();

        for (Map.Entry<String,Object> entry : jobDataMap.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String && !key.equals(JOB_NAME)){
                builder.addString(key,(String)value);
            }else if (value instanceof Float || value instanceof Double){
                builder.addDouble(key,((Number)value).doubleValue());
            }else if (value instanceof Integer || value instanceof Long){
                builder.addLong(key,((Number)value).longValue());
            }else if (value instanceof Date){
                builder.addDate(key,(Date)value);
            }else {
                //JobDataMap contains values which are not job parameters
                //(ignoring)
            }
        }

        //need unique job parameter to return the same job
        builder.addDate("run date",new Date());

        return builder.toJobParameters();
    }
}
