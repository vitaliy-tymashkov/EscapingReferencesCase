
import java.util.HashMap;
import java.util.Map;

public class Price implements IPriceReadOnly {

	private Map<String,Double> rates;
	private Double value;
	
	public Price(Double value) {
		this.value = value;
		rates = new HashMap<String,Double>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	public Double convert(String toCurrency) {

		if (toCurrency.equals("USD")) {

			//NOTE: escaping reference #3.1 - updating the value
			/*return value;*/

			//Fix - to keep the value as it is
			return new Double(value);
		}
		else {
			Double conversion = rates.get("USD") / rates.get(toCurrency);
			//NOTE: escaping reference #3.2 - updating the value
			// Error here - by retrieving the price we update the value!
			/*value = conversion * value;
			return value;*/

			//Fix - to keep the value as it is and return a new variable
			Double result = conversion * value;
			return result;
		}
	}

	@Override
	public Map<String,Double> getRates() {
		//NOTE: escaping reference #4
		/*return rates;*/

		//Fixed by returning a new HashMap - so we do not care about mutations
		return new HashMap<> (rates);
	}

}
