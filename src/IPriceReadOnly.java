import java.util.Map;

public interface IPriceReadOnly {
    String toString();

    Map<String,Double> getRates();
}
