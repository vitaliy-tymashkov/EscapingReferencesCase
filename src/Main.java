import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class Main {
	private final static String CURRENCY_EUR = "EUR";
	private final static String CURRENCY_USD_DEFAULT = "USD";

	public static void main(String[] args) {
		String searchBookTitle = "Tom Jones";

		BookCollection bc = new BookCollection();
		bc.printAllBooks();

		//Escaping reference #1 - in BookCollection.findBookByName()
		//Fixed by extracting interface IBookReadOnly (only with getters) - so the statement below is not accessible
//		bc.findBookByName("Tom Jones").setPrice(800D);							// Update price in a wrong manner - Fixed

		//Escaping reference #2 - in Book.getPrice()
		//Error was in original method - by retrieving the price we were updating the value! - fix #1 has helped
		System.out.println(searchBookTitle + " book price is "
				+ bc.findBookByName(searchBookTitle).getPrice() + " " + CURRENCY_USD_DEFAULT);

		//Escaping reference #3 - in Price.convert()
		//Error was in original method - by retrieving the price we were updating the value! - fix #1 has helped
		System.out.println(searchBookTitle + " book price is "
				+ bc.findBookByName(searchBookTitle).getPrice().convert(CURRENCY_EUR) + " " + CURRENCY_EUR); // Fixed

		//Escaping reference #4 - in Price.getRates()
		//Fixed by returning a copy of rates collection
		bc.findBookByName(searchBookTitle).getPrice().getRates().put(CURRENCY_EUR, 0.1); 	// Update rate in
																							// a wrong manner!
																							// Fix #1 has helped



		//*************************************************************************************************************
		// Normal Result (9.99 /0.8 = 12.4875)
		//get price of book called Tom Jones in EUR
		System.out.println(searchBookTitle + " book price is " + bc.findBookByName(searchBookTitle).getPrice().convert(CURRENCY_EUR) + " " + CURRENCY_EUR);

		bc.printAllBooks();
	}
}
