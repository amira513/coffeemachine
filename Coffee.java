package coffeemachine;

// Crea una classe per il caffè con nome e prezzo
public class Coffee {
	private String name;
	private double price;

	// Costruttore per il caffè con nome e prezzo per inizializzare i valori
	public Coffee(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// Getter per ottenere il nome del caffè
	public String getName() {
		return name;
	}

	// Getter per ottenere il prezzo del caffè
	public double getPrice() {
		return price;
	}

	// Metodo toString per restituire il nome e il prezzo in formato stringa
	public String toString() {
		return name + " - " + price + " euro";
	}
}