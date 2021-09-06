package ex5_conc_collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) {

		/*
		 * Se https://docs.oracle.com/javase/8/docs/api/?java/util/concurrent/package-
		 * summary.html
		 * 
		 * A Queue that additionally supports operations that wait for the queue to
		 * become non-empty when retrieving an element, and wait for space to become
		 * available in the queue when storing an element.
		 */
		BlockingQueue<String> bq = new LinkedBlockingQueue<>(3); // Plass til maks 3

		/*
		 * Kan v�re delt ressurs mellom tr�der. K�en blokkerer (setter tr�d p� wait)
		 * tr�der som pr�ver � ta ut element fra tom k�, og tr�der som pr�ver � legge
		 * til element i full k�. K� med automatisk wait/notify (evt. await/signal) rett
		 * ut av boksen. :)
		 */

		Thread producer = new Thread() {
			@Override
			public void run() {
				try {
					for (int i = 1; i <= 10; i++) {
//						bq.add("" + i + ". mann i k�en."); // Samme som i Queue
//						bq.offer("" + i + ". mann i k�en.");
						bq.put("" + i + ". mann i k�en.");
					}
				} catch (Exception e) {
				}
			}
		};

		Thread consumer = new Thread() {
			@Override
			public void run() {
				try {
					for (int i = 1; i <= 10; i++) {
//						System.out.println(bq.remove()); // Samme som i Queue
//						System.out.println(bq.poll());   // Samme som i Queue
						System.out.println(bq.take());
					}
				} catch (Exception e) {
				}
			}
		};

		producer.start();
		consumer.start();
	}

}