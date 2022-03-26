import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
             int min=3600;
             int i=0;
             int pozitie=0;
        for(Server s: servers)
        {   i++;
            if(s.getTasks().size()<min)
            {
                pozitie=i;
                min=s.getTasks().size();
            }
        }

        servers.get(pozitie).addTask(t);
    }
}
