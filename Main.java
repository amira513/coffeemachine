package coffeemachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Crea una nuova macchina del caffè
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		Scanner scanner = new Scanner(System.in);

		// Chiede all'utente di inserire soldi
		double balance_iniziale = getValidAmount(scanner, "Quanto soldi vuoi inserire?");
		coffeeMachine.addMoney(balance_iniziale);

		// Loop per continuare a eseguire il programma fino a quando l'utente non esce
		boolean running = true;
		while (running) {
			System.out.println("\n===== MACCHINA DEL CAFFE' =====");
			System.out.println("1. Mostra il menu del caffè");
			System.out.println("2. Aggiungi soldi");
			System.out.println("3. Seleziona un caffè");
			System.out.println("4. Restituisci il resto");
			System.out.println("5. Esci");
			System.out.println("===============================");
			System.out.print("Seleziona un'opzione (1-5): ");

			try {
				int choice = scanner.nextInt();
				switch (choice) {
					case 1:
						coffeeMachine.printCoffeeList();
						break;

					case 2:
						double amount = getValidAmount(scanner, "Quanti soldi vuoi aggiungere?");
						coffeeMachine.addMoney(amount);
						break;

					case 3:
						coffeeMachine.printCoffeeList();
						System.out.print("Seleziona un caffè: ");
						int coffeeChoice = scanner.nextInt();
						coffeeMachine.buyCoffee(coffeeChoice);
						break;

					case 4:
						coffeeMachine.change();
						break;

					case 5:
						// Esci dal prog ramma
						coffeeMachine.change();
						System.out.println("Grazie per aver usato la nostra macchina del caffè!");
						running = false;
						break;

					default:
						System.out.println("Selezionato un numero non valido! Per favore inserire un numero valido.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Inserire un numero valido!");
				scanner.nextLine(); // Pulisce l'input non valido
			}
		}

		// Chiude lo scanner
		scanner.close();
	}

	private static double getValidAmount(Scanner scanner, String prompt) {
		double amount = 0.00;

		while (true) {
			// Stampa il prompt
			System.out.print(prompt);
			try {
				// Legge l'input dell'utente che è un numero
				amount = scanner.nextDouble();
				// Se la somma non è positiva, stampa un messaggio di errore
				if (amount <= 0) {
					System.out.println("Inserire una somma positiva.");
				} else {
					break; // Esci dal ciclo se l'importo è valido
				}
			} catch (InputMismatchException e) {
				System.out.println("Inserire un numero valido!");
				scanner.nextLine(); // Pulisce l'input non valido
			}
		}

		return amount;
	}
}
  