import java.math.BigDecimal;

/**
 * Модель клиента с координатами и индексом.
 */
public class Client {
    public final int index;
    public final BigDecimal x, y;

    public Client(int index, BigDecimal x, BigDecimal y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public BigDecimal distanceSquared(Client other) {
        BigDecimal dx = x.subtract(other.x);
        BigDecimal dy = y.subtract(other.y);
        return dx.multiply(dx).add(dy.multiply(dy));
    }
}