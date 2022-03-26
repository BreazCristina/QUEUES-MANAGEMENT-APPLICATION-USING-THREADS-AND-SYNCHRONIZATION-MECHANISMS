import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server(int Max_Tasks_per_Server)
    {

        waitingPeriod=new AtomicInteger(0);
        tasks= new ArrayBlockingQueue<Task>(Max_Tasks_per_Server);

        }

    public void addTask(Task newTask)
    {
        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }
    public void run()
    {
          while(true)
          {

              Task t=tasks.peek();
              try {
                  Thread.sleep(t.getServiceTime());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              waitingPeriod.addAndGet(-t.getServiceTime() );
          }

    }

    public BlockingQueue<Task> getTasks()
    {
        return tasks;

    }
    public AtomicInteger getWaitingPeriod()
    {
        return waitingPeriod;
    }
}
