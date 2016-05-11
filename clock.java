import java.util.TimerTask;
import java.util.ArrayList;
public class Clock extends TimerTask
{
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public Clock(ArrayList<Bullet> bullets)
    {
        this.bullets = bullets;
    }

    public void run()
    {
        for (int i = 0; i < bullets.size(); i++)
        {
            bullets.get(i).move();
        }
    }
}
