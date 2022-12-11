import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	
	Queue<Integer> queue = new PriorityQueue<>();
	Random rand = new Random();
	
	public CarQueue() {
		queue.add(0);
		queue.add(1);
		queue.add(3);
		queue.add(2);
		queue.add(0);
	}

	public void addToQueue() {
		class MyRunnable implements Runnable {

			@Override
			public void run() {
				try {
					queue.add(rand.nextInt(4));
					queue.add(rand.nextInt(4));
					queue.add(rand.nextInt(4));
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}	
			}	
		}
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public int deleteQueue() {
		if(!queue.isEmpty()) {
			return queue.remove();
		}
			else {
				return 0;
		}
	}

}
