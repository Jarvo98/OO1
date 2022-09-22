package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class FIFOJobScheduler extends JobScheduler {

    public FIFOJobScheduler() {
        super();
    }

    @Override
    public JobDescription next() {
        return this.unscheduleAndReturn(this.getFirstJob());
    }

    private JobDescription getFirstJob() {
        return this.getJobs().get(0);
    }

}
