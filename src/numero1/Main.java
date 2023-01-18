package numero1;

public class Main {

	public static void main(String[] args) {
		Simbolo s1 = new Simbolo('*');
		Simbolo s2 = new Simbolo('#');
		
		s1.start();
		s2.start();
	}

}

class Simbolo extends Thread {
	
	private char simbolo;
	
	public Simbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(this.simbolo);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
