import java.util.TimerTask;

public class Clock2 extends TimerTask
{
    private Target target;
    public Clock2(Target target)
    {
        this.target = target;
    }
    public void run()
    {
        target.randomMovement();
        
    }
}
