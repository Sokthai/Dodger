import java.security.SecureRandom;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class sound implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String taskName;
    
    public sound(String taskName){
        this.taskName = taskName;
        sleepTime = generator.nextInt(5000);//5 seconds
        
    }
    
    public void run(){ //when implement Runnable interface(java.lang) must override run() for the concurrency/ thread
        try{
            System.out.printf("%s going to sleep for %d milliseconds. %n", taskName, sleepTime);
            Thread.sleep(sleepTime);
        }catch (InterruptedException exception){
            exception.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.printf("%s done sleeping %n", taskName);
    }
    
    
    
    public static void main(String[] args) {
        
        sound task1 = new sound("task1");
        sound task2 = new sound("task2");
        sound task3 = new sound("task3");
        
        System.out.println("Starting Executor");
        ExecutorService executorService = Executors.newCachedThreadPool();
        ///start the threee sounds
        executorService.execute(task1);//when this method is called, it will run the run method in the PrintTank class
        executorService.execute(task2);
        executorService.execute(task3);
        //notifies the ExecutorService to stop accepting new tasks, but to continues executing task that already been submitted
        //once all of previously submitted Runnable have completed, the ExecutorService Terminated.
        executorService.shutdown();
        System.out.printf("Tasks started, main ends %n%n");
    }
}