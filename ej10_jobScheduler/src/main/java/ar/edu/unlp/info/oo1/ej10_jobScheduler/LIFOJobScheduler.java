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
        try {
            return this.getJobs().get(this.jobsCount() - 1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

}
