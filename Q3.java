class ExamTask implements Runnable {

    String activity;
    int delay;

    ExamTask(String activity, int delay) {
        this.activity = activity;
        this.delay = delay;
    }

    public void run() {

        for (int i = 1; i <= 3; i++) {

            System.out.println(
                Thread.currentThread().getName()
                + " : " + activity
            );

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Q3 {

    public static void main(String[] args) {

        Thread t1 = new Thread(
            new ExamTask("Displaying remaining time", 1000)
        );

        Thread t2 = new Thread(
            new ExamTask("Auto-saving answers", 1500)
        );

        Thread t3 = new Thread(
            new ExamTask("Checking network connection", 2000)
        );

        t1.setName("Time Thread");
        t2.setName("AutoSave Thread");
        t3.setName("Network Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}