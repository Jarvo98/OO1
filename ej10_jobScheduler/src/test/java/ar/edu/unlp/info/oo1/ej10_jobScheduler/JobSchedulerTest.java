package ar.edu.unlp.info.oo1.ej10_jobScheduler;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class JobSchedulerTest {
    protected JobDescription firstJob;
    protected JobDescription highestPriorityJob;
    protected JobDescription mostEffortJob;
    protected JobDescription lastJob;
  
    
    private void initializeJobs() {
    	
    	firstJob = new JobDescription (1, 1, "Este es el primero");
    	highestPriorityJob = new JobDescription (1, 100, "Este es el de m�s prioridad");
    	mostEffortJob = new JobDescription (100, 1, "Este es el de m�s esfuerzo");
    	lastJob = new JobDescription (1, 1, "Este es el �ltimo");
    	
    }
    
    @BeforeEach
    void setUp() {
    	this.initializeJobs();
    } 
    
    private FIFOJobScheduler newFifoScheduler() {
    	return new FIFOJobScheduler();
    }
    
    private LIFOJobScheduler newLifoScheduler() {
    	return new LIFOJobScheduler();
    }
    
    private HighestPriorityJobScheduler newPriorityScheduler() {
    	return new HighestPriorityJobScheduler();
    }
    
    private MostEffortJobScheduler newEffortScheduler() {
    	return new MostEffortJobScheduler();
    }
    
    private void scheduleJobsIn(JobScheduler aJobScheduler) {
    	aJobScheduler.schedule(firstJob);
    	aJobScheduler.schedule(highestPriorityJob);
    	aJobScheduler.schedule(mostEffortJob);
    	aJobScheduler.schedule(lastJob);
    }
    
    @Test
    void testSchedule() {
    	JobScheduler aScheduler = new FIFOJobScheduler();
    	aScheduler.schedule(highestPriorityJob);
    	assertTrue(aScheduler.hasJob(highestPriorityJob));
    } 
    
    @Test
    void testUnschedule() {
    	JobScheduler aScheduler = new FIFOJobScheduler();
    	this.scheduleJobsIn(aScheduler);
    	aScheduler.unschedule(highestPriorityJob);
    	assertFalse(aScheduler.hasJob(highestPriorityJob));
    }
    
    @Test
    void testNext() {
    	JobScheduler scheduler;
    	
    	scheduler = this.newFifoScheduler();
    	this.scheduleJobsIn(scheduler);
    	assertEquals(scheduler.next(), firstJob);
    	assertEquals(scheduler.jobsCount(), 3);
    	
    	scheduler = this.newLifoScheduler();
    	this.scheduleJobsIn(scheduler);
    	assertEquals(scheduler.next(), lastJob);
    	assertEquals(scheduler.jobsCount(), 3);

    	scheduler = this.newPriorityScheduler();
    	this.scheduleJobsIn(scheduler);
    	assertEquals(scheduler.next(), highestPriorityJob);
    	assertEquals(scheduler.jobsCount(), 3);

    	scheduler = this.newEffortScheduler();
    	this.scheduleJobsIn(scheduler);
    	assertEquals(scheduler.next(), mostEffortJob);
    	assertEquals(scheduler.jobsCount(), 3);
    }

	@Test
	void testNextWhenThereAreNoJobs() {
		FIFOJobScheduler fifoJobScheduler = this.newFifoScheduler();
		LIFOJobScheduler lifoJobScheduler = this.newLifoScheduler();
		HighestPriorityJobScheduler highestPriorityJobScheduler = this.newPriorityScheduler();
		MostEffortJobScheduler mostEffortJobScheduler = this.newEffortScheduler();

		assertNull(fifoJobScheduler.next());
		assertNull(lifoJobScheduler.next());
		assertNull(highestPriorityJobScheduler.next());
		assertNull(mostEffortJobScheduler.next());
	}
}
