package coffeemachine;

import java.util.ArrayList;
import java.util.List;

// Crea una classe per la macchina del caffè con una lista di caffè e un saldo
public class CoffeeMachine {
	private List<Coffee> coffeeList;
	private double balance;

	// Costruttore per la macchina del caffè con lista di caffè e saldo per inizializzare le variabili della classe
	public CoffeeMachine() {
		coffeeList = new ArrayList<>();

		// Aggiungi caffè alla lista di caffè
		coffeeList.add(new Coffee("Espresso", 1.50));
		coffeeList.add(new Coffee("Latte", 2.00));
		coffeeList.add(new Coffee("Cappuccino", 2.50));
		coffeeList.add(new Coffee("Americano", 1.00));
		coffeeList.add(new Coffee("Mocha", 3.00));
		coffeeList.add(new Coffee("Macchiato", 1.50));
		coffeeList.add(new Coffee("Cioccolato caldo", 3.50));

		balance = 0.00;
	}

	// Metodo per stampare la lista di caffè
	public void printCoffeeList() {
		System.out.println("Benvenuto nella macchina del caffè!");
		System.out.println("Caffè disponibili:");

		// Stampa la lista di caffè
		for (int i = 0; i < coffeeList.size(); i++) {
			System.out.println((i + 1) + ". " + coffeeList.get(i));
		}
	}

	public void addMoney(double amount) {
		if (amount < 0) {
			System.out.println("Importo non valido. Inserisci un numero positivo.");
		} else {
			System.out.println("Aggiunto " + amount + " euro al saldo");
			balance += amount;
			System.out.println("Saldo attuale: " + balance + " euro");
		}
	}

	// Metodo per ottenere il saldo
	public double getBalance() {
		return balance;
	}

	// Metodo per acquistare caffè
	public boolean buyCoffee(int choice) {


		// Valida l'input dell'utente
		if (choice < 1 || choice > coffeeList.size()) {
			System.out.println("Scelta non valida. Riprova.");
			return false;
		}

		// Ottieni il caffè selezionato
		Coffee selectedCoffee = coffeeList.get(choice - 1);

		// Controlla se il saldo è sufficiente per acquistare il caffè
		if (balance < selectedCoffee.getPrice()) {
			System.out.println("Saldo insufficiente. Aggiungi più soldi.");
			return false;
		}

		// Sottrai il prezzo dal saldo
		balance -= selectedCoffee.getPrice();
		System.out.println("Hai selezionato " + selectedCoffee.getName() + " e il tuo saldo è " + balance + " euro");
		return true;
	}

	public double change() {
		double change = balance;
		if (change > 0) {
			System.out.println("Ecco il tuo resto: " + change + " euro");
			balance = 0;
		} else {
			System.out.println("Nessun resto da restituire");
		}
		return change;
	}


}

         


