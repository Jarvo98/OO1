package ar.edu.unlp.info.oo1.ej10_jobScheduler;


import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {
    private List<JobDescription> jobs;
     
    public JobScheduler () {
    	this.jobs = new ArrayList<>();
    }
    
    public void schedule(JobDescription job) {
    	this.getJobs().add(job);
    }

    public void unschedule(JobDescription job) {
    	if (job != null) {
    	   this.getJobs().remove(job);
    	}
    }

    public boolean hasJob(JobDescription job) {
        return this.getJobs().contains(job);
    }

    public int jobsCount() {
        return this.getJobs().size();
    }

    public abstract JobDescription next();

    protected List<JobDescription> getJobs() {
        return this.jobs;
    }

    protected JobDescription unscheduleAndReturn(JobDescription job) {
        this.unschedule(job);
        return job;
    }

}

