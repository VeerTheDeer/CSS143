public class Multi implements Runnable {
	private String threadName = "";

	public Multi(String newThreadName) {
		threadName = newThreadName;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			if (Math.random() < 0.5) {
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(threadName + " : " + i);
		}
	}

	public static void main(String[] args) {
		Thread worker1 = new Thread(new Multi("Worker1"));
		Thread worker2 = new Thread(new Multi("Worker2"));

		worker1.start();
		worker2.start();
	}
}
