import java.util.TimerTask;
/**
 * The Clock2 class is a subclass of TimerTask and it calls the movement method of the target class inside its
 * run method. This allows the target method to be called after a certain amount of time has passed, multiple
 * times, creating an animation effect. 
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public class Clock2 extends TimerTask
{
    private Target target;
    public Clock2(Target target)
    {
        //Sets the instance variable target to the parameter variable target
        this.target = target;
    }
    /**
     * run method calls the movement method in the target class
     */
    public void run()
    {
        target.movement();
        
    }
}
