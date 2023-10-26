import java.util.ArrayList;
import java.util.List;

public class CustomTimer {
    private List<TimerTask> tasks = new ArrayList<>();

    public void schedule(TimerTask task, long delay) {
        task.schedule(delay);
        tasks.add(task);
    }

    public void cancel(TimerTask task) {
        task.cancel();
        tasks.remove(task);
    }

    public void run() {
        long currentTime = System.currentTimeMillis();
        for (TimerTask task : new ArrayList<>(tasks)) {
            task.run();
        }
    }
}