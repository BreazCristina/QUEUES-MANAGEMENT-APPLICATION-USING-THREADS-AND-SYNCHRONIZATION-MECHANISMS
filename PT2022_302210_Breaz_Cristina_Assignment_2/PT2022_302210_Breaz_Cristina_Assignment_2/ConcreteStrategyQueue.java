import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
             int min=3600;
            //int i=0;
             int pozitie=0;
        for(int i=0; i<servers.size();i++)
        {

            if(servers.get(i).getTasks().size()<min)
            {
                pozitie=i;
                min=servers.get(i).getTasks().size();
            }
        }

        servers.get(pozitie).addTask(t);
    }
}
