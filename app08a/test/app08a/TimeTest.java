package app08a;

import java.sql.Time;

public class TimeTest {
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println((end-start)/1000);
	}

}
