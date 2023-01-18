package numero3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;


public class RegistroPresenze {
	
	private static final String ENCODING = "utf-8";

	public static void main(String[] args) {
		
		String fileName = "presenze.txt";
		File file = new File(fileName);
		Scanner scan = new Scanner(System.in);
		
		if(file.exists()) {
			System.out.printf("File %s trovato%n", fileName);
			
			System.out.println("Scrivi sul file:");
			
			try {
				System.out.println("Scrivi nome della persona");
				String nome = scan.nextLine();
				
				System.out.println("Scrivi quanti giorni di presenza ha fatto");
				int ggPresenze = scan.nextInt();
				
				Presenza p1 = new Presenza(nome, ggPresenze);
				
				scriviSuFile(file, p1.toString(), true);
				System.out.println("Prezenza aggiunta!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Leggi il file:");
			
			try {
				leggiFile(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.printf("il file %s non esiste %n", fileName);			
		}
		
		scan.close();
		
	}
	
	public static void scriviSuFile(File file, String str, boolean aggiungi) throws IOException {
		FileUtils.writeStringToFile(file, str, ENCODING, true);
	}

	public static void leggiFile(File file) throws IOException {
		System.out.println(FileUtils.readFileToString(file, ENCODING));
		
		/*
		String content = FileUtils.readFileToString(file, ENCODING);
		
		String[] segments = content.split("#");
		
		try {
			Presenza p = new Presenza(segments[0], Integer.parseInt(segments[1]));
			System.out.println(p);
		} catch(NumberFormatException e) {
			System.out.println( "Error!" );
		}
		*/
	}
	
}
