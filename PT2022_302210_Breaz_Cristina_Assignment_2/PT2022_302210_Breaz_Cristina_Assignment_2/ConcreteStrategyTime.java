import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcreteStrategyTime implements Strategy{

    @Override
    public void addTask(List<Server> servers, Task t) {
        //TODO Auto-generated method stub;
            int min= Integer.MAX_VALUE;
           // int i=0;
            int pozitie=0;
            for(int index=0; index<servers.size(); index++)
            {

                int intValue = servers.get(index).getWaitingPeriod().intValue();
                if(intValue < min )
                {
                    pozitie=index;
                    min=intValue;
                }
            }

            servers.get(pozitie).addTask(t);
        }
    }

