package numero2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> l1 = new ArrayList<>(3000);

		for(int i = 0; i < 3000; i++) {
			int nR = new Random().nextInt(101);
			l1.add(nR);
		}
		
		ArrayParziale thread1 = new ArrayParziale(l1, 0, 999);
		ArrayParziale thread2 = new ArrayParziale(l1, 1000, 1999);
		ArrayParziale thread3 = new ArrayParziale(l1, 2000, 2999);
		

		
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
		thread3.start();
		
		System.out.println("L'array thread1 " + thread1.ottieniSommaParziale());
		System.out.println("L'array thread2 " + thread2.ottieniSommaParziale());
		System.out.println("L'array thread3 " + thread3.ottieniSommaParziale());
		
		long sommaTotale = thread1.ottieniSommaParziale() + thread2.ottieniSommaParziale() + thread3.ottieniSommaParziale();
		
		System.out.println("La somma totale è: " + sommaTotale);
		
		

	}

}

class ArrayParziale extends Thread {
	
	private List<Integer> list;
	private int startIndex;
	private int endIndex;
	private long sommaParziale;
	
	public ArrayParziale(List<Integer> list, int startIndex, int endIndex) {
		this.list = list;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	public long ottieniSommaParziale() {
		return sommaParziale;
	}
	
	@Override
	public void run() {
		for(int i = startIndex; i < endIndex; i++) {
			sommaParziale += list.get(i);
		}
	}
	
}
