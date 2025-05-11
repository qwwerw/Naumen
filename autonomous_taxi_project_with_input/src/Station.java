import java.util.Set;

/**
 * Представляет станцию и множество клиентов, которых она обслуживает.
 */
public class Station {
    public final int clientIndex;
    public final Set<Integer> coveredClients;

    public Station(int clientIndex, Set<Integer> coveredClients) {
        this.clientIndex = clientIndex;
        this.coveredClients = coveredClients;
    }
}