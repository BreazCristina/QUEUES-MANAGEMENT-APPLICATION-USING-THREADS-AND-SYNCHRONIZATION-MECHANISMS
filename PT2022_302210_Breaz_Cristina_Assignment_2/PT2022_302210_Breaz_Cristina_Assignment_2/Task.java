public class Task implements Comparable{

    private int arrivalTime;
    private int serviceTime;
    private int ID;
    public Task(int arrivalTime, int serviceTime,int ID)
    {
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
        this.ID=ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getID(){return ID;}

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Object o) {

        Task t= (Task)o;
        if( arrivalTime < t.getArrivalTime()) return -1;
        else return 1;

    }

    @Override
    public String toString() {
        return "(" +
                arrivalTime +", "+
                serviceTime +", "+

                 ID +
                ")";
    }
}
