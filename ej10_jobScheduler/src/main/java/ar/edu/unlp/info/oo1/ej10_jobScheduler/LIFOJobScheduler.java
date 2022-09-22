package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class LIFOJobScheduler extends JobScheduler {

    public LIFOJobScheduler() {
        super();
    }

    @Override
    public JobDescription next() {
        return this.unscheduleAndReturn(this.getLastJob());
    }

    private JobDescription getLastJob() {
        return this.getJobs().get(this.jobsCount() - 1);
    }

}
