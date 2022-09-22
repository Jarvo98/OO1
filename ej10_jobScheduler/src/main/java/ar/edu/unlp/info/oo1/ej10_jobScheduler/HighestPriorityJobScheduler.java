package ar.edu.unlp.info.oo1.ej10_jobScheduler;

import java.util.Comparator;

public class HighestPriorityJobScheduler extends JobScheduler {

    public HighestPriorityJobScheduler() {
        super();
    }

    @Override
    public JobDescription next() {
        return this.unscheduleAndReturn(this.getHighestPriorityJob());
    }

    private JobDescription getHighestPriorityJob() {
        return
                this.getJobs()
                .stream()
                .max(Comparator.comparingDouble(JobDescription::getPriority))
                .orElse(null);
    }

}
