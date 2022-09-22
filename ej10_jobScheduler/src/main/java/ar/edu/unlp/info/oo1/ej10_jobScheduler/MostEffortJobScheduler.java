package ar.edu.unlp.info.oo1.ej10_jobScheduler;

import java.util.Comparator;

public class MostEffortJobScheduler extends JobScheduler {

    public MostEffortJobScheduler() {
        super();
    }

    @Override
    public JobDescription next() {
        return this.unscheduleAndReturn(this.getMostEfforJob());
    }

    private JobDescription getMostEfforJob() {
        return
                this.getJobs()
                .stream()
                .max(Comparator.comparingDouble(JobDescription::getEffort))
                .orElse(null);
    }

}
