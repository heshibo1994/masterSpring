package com.smart.attr;

import java.util.*;

public class Boss {
    private List favorites = new ArrayList<String>();
    private Map jobs = new HashMap();
    private Properties mails = new Properties();
    private Map<String,Integer> jobTimes = new HashMap<String,Integer>();

    public Map<String, Integer> getJobTimes() {
        return jobTimes;
    }

    public void setJobTimes(Map<String, Integer> jobTimes) {
        this.jobTimes = jobTimes;
    }

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public List getFavorites(){
        return favorites;
    }
    public void setFavorites(List favorites){
        this.favorites = favorites;

    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }
}
