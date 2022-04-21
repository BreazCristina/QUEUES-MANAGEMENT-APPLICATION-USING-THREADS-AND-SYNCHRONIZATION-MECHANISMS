import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer)
    {
         servers= new ArrayList<>();
         for(int i=0; i< maxNoServers;i++)
         {
            Server server= new Server(maxTasksPerServer);
            Thread t= new Thread(server);
            this.servers.add(server);
            t.start();
         }


    }
   public void changeStrategy(SelectionPolicy policy) {
       //aply strategy patter to instantiate the strategy with the concrete
       //strategy coresponding to politicy;

       if (policy == SelectionPolicy.SHORTEST_QUEUE) {
           strategy = new ConcreteStrategyQueue();
       }
       if (policy == SelectionPolicy.SHORTEST_TIME)
       {
           strategy= new ConcreteStrategyTime();
       }
   }

   public void dispatchTask(Task t)
   {
       strategy.addTask(servers, t);
   }
   public List<Server> getServers()
   {
       return servers;
   }
}
