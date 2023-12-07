public class Foo implements Runnable {

    private String taskName;

    public Foo(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        System.out.println(taskName + " is in progress");
        for (int i = 0; i < 5; i++) {
            System.out.println(taskName + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task " + taskName + " has completed.");
    }

    public static void main(String[] args) {
        Thread worker1 = new Thread(new Foo("Worker1"));
        Thread worker2 = new Thread(new Foo("Worker2"));

        worker1.start();
        worker2.start();
    }
}
