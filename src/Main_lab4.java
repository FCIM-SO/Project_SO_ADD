public class Main_lab4 {
    public static void main(String[] args) {
        CustomTimer timer = new CustomTimer();

        TimerTask t1 = new TimerTask(() -> {
            System.out.println("Task 1: Wake up at 7 a.m");
        });

        TimerTask t2 = new TimerTask(() -> {
            System.out.println("Task 2: Have a breakfast at 8 a.m");
        });

        TimerTask t3 = new TimerTask(() -> {
            Runnable customAction = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Task 3: Go to university");
                }
            };

            TimerTask customTask = new TimerTask(customAction);
            customTask.schedule(2000); // Запуск анонимной задачи через 2 секунды
            timer.schedule(customTask, 2000);
        });


    }
}