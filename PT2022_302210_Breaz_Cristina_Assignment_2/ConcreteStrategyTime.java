import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteStrategyTime implements Strategy{

    @Override
    public void addTask(List<Server> servers, Task t) {
        //TODO Auto-generated method stub;
            int min= 3600;
            int i=0;
            int pozitie=0;
            for(Server s: servers)
            {
                i++;
                int intValue = s.getWaitingPeriod().get();
                if(intValue < min )
                {
                    pozitie=i;
                    min=intValue;
                }
            }

            servers.get(pozitie).addTask(t);
        }
    }

