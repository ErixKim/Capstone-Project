import java.util.TimerTask;

public class Clock extends TimerTask
{
    private Target target;
    public Clock(Target target)
    {
        this.target = target;

    }

    public void run(){
        target.randomMovement();
    }
}