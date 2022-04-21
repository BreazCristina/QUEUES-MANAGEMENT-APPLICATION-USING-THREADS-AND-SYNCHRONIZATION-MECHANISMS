import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class SimulationManager implements Runnable{

   //trebuie citita din UI
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    public int maxArrivalTime;
    public int minArrivalTime;
    public int averageServiceTime=0;
    public SelectionPolicy selectionPolicy ;

    private Scheduler scheduler;
   // private SimulationFrame frame;
    private List<Task> generatedTasks;


     public SimulationManager(int timeLimit , int maxProcessingTime, int minProcessingTime, int numberOfServers , int numberOfClients, int maxArrivalTime, int minArrivalTime,String selectionPolicy) {
         this.timeLimit=timeLimit;
         this.maxProcessingTime=maxProcessingTime;
         this.minProcessingTime=minProcessingTime;
         this.numberOfServers=numberOfServers;
         this.numberOfClients=numberOfClients;
         this.maxArrivalTime=maxArrivalTime;
         this.minArrivalTime=minArrivalTime;
         this.selectionPolicy= SelectionPolicy.valueOf(selectionPolicy);
         this.scheduler = new Scheduler(numberOfServers, numberOfClients);
         generatedTasks= new ArrayList<Task>();
         scheduler.changeStrategy(SelectionPolicy.valueOf(selectionPolicy));
         generateNRandomTasks();


         //Strategy selectionStrategy =
     }

     private void generateNRandomTasks()
     {
        // ArrayList<Task> list = new ArrayList<>();
         for(int i=0;i <numberOfClients;i++)
         {
             Random a = new Random();
             int serviceTime= a.nextInt(maxProcessingTime-minProcessingTime) + minProcessingTime;

             int arrivalTime =a.nextInt(maxArrivalTime-minArrivalTime) + minArrivalTime;
             int ID=i;
             Task t= new Task(arrivalTime,serviceTime,ID);
             averageServiceTime=averageServiceTime+serviceTime;
             generatedTasks.add(t);
         }
         Collections.sort(generatedTasks);
         for(Task t: generatedTasks)
         {
             System.out.println(t);

             View.getTextArea().append(t.toString());
         }
         View.getTextArea().append("\n");


         //a.nextInt();


     }

    public Scheduler getScheduler() {
        return scheduler;
    }

    @Override
    public void run() {
           FileWriter file=null;
           try
           {
               file=new FileWriter("Test3.txt");
           }catch (IOException e)
           {
               e.printStackTrace();
           }
          PrintWriter print = new PrintWriter(file);
           int currentTime=0;
             int max=-1;
             int peakhour=-1;
           while(currentTime<timeLimit)
           {
               print.println(currentTime);
               View.getTextArea().append(""+currentTime+"\n");
               int nbc=0;
               for(int i=0;i<scheduler.getServers().size();i++)
               {
                   if(scheduler.getServers().get(i).getTasks().size()>0)
                       nbc=nbc+scheduler.getServers().get(i).getTasks().size();
                   //System.out.println(nbc);

               }
               if(nbc> max) {
                   max = nbc;
                   peakhour = currentTime;
               }
             // System.out.println(nbc);


               for(int i=0;i<generatedTasks.size(); i++)
               {

                  if(generatedTasks.get(i).getArrivalTime()==currentTime)
                  {
                      scheduler.dispatchTask(generatedTasks.get(i));
                      generatedTasks.remove(i--);
                     // break;
                  }


               }

               for(int i=0;i<scheduler.getServers().size();i++) {

                    String str=scheduler.getServers().get(i).getTasks().toString();
                  // System.out.println("Coada "+(i+1));
                  // System.out.println(str);
                   View.getTextArea().append("Coada" + (i+1) +":");
                   View.getTextArea().append(str+"\n");
                   print.println("Coada" + (i+1));
                   print.println(str);
               }

               for(int i=0;i<scheduler.getServers().size();i++)
               {

                   if(scheduler.getServers().get(i).getTasks().peek()!=null) {
                       int sv=scheduler.getServers().get(i).getTasks().peek().getServiceTime();
                       if (sv > 0) scheduler.getServers().get(i).getTasks().peek().setServiceTime(sv - 1);
                       else if (sv == 0) scheduler.getServers().get(i).getTasks().remove();
                   }
               }
               currentTime++;
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }

        View.getTextArea().append("Average Service Time este:" + (float)averageServiceTime/numberOfClients + "\n");
           View.getTextArea().append("Waiting Time este:" + (float)averageServiceTime/numberOfClients/numberOfServers + "\n");
           View.getTextArea().append("Peak Hour is " + peakhour);
        print.println("Average Service Time este:" + (float)averageServiceTime/numberOfClients);
           print.println("Wainting Time este:"+ (float)averageServiceTime/numberOfClients/numberOfServers);
              // System.out.println(generatedTasks.get(i));
           print.println("Peak Hour is " +peakhour +" and the number of clients is: " + max);
       // System.out.println("si aici");
        print.close();
    }




    public static void main(String[] args)
    {
        //SimulationManager gen=new SimulationManager();
       // Thread t = new Thread(gen);
        View view = new View();
        Controller controller= new Controller(view);
       // view.setVisible(true);
       // t.start();

    }
}


