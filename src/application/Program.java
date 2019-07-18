package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import model.entities.LogEntry;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>();
			
			//ler arquivo e guarda na varaivel
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(" "); //recorte da string
				String username = fields[0]; //variavel para apenas os nomes
				Date moment = Date.from(Instant.parse(fields[1])); //variavel Date para a data
				
				set.add(new LogEntry(username, moment)); //inserir no set
				
				line = br.readLine(); //ler a proxima linha	
			}
			
			System.out.println("Total users: " + set.size()); //mostrar quantidade
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
