import java.util.Timer;
import java.util.TimerTask;

public class Main_lab4 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask t1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 1: Wake up at 7 a.m");
            }
        };

        TimerTask t2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task 2: Have breakfast at 8 a.m");
            }
        };

        TimerTask t3 = new TimerTask() {
            @Override
            public void run() {
                Runnable customAction = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task 3: Go to university");
                    }
                };

                Timer customTimer = new Timer();
                TimerTask customTask = new TimerTask() {
                    @Override
                    public void run() {
                        customAction.run();
                    }
                };
                customTimer.schedule(customTask, 2000); // Запуск анонимной задачи через 2 секунды
            }
        };

        timer.schedule(t1, 3000); // Запуск первой задачи через 3 секунды
        timer.schedule(t2, 10000); // Запуск второй задачи через 10 секунд
        timer.schedule(t3, 15000); // Запуск третьей задачи через 15 секунд

        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 20000) {
            // Делаем некоторую работу в основном потоке, чтобы не завершить программу сразу
        }
    }
}
