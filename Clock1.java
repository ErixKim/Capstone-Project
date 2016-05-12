import java.util.TimerTask;
import java.util.ArrayList;
/**
 * The Clock class is a subclass of TimerTask and it calls the move method of the bullet class inside its
 * run method. This allows the move method to be called after a certain amount of time has passed, multiple
 * times. 
 * 
 * @author Eric Kim
 * @version 5/11/2016
 */
public class Clock1 extends TimerTask
{
    //Private instance variable to hold the bullets created
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public Clock1(ArrayList<Bullet> bullets)
    {
        //Sets bullets instance variable to parameter variable bullets
        this.bullets = bullets;
    }

    /**
     * run method to call the move method in the bullet class
     */
    public void run()
    {
        for (int i = 0; i < bullets.size(); i++)
        {
            bullets.get(i).move();
        }
    }
}
