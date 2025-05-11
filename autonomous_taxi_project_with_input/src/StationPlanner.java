import java.math.BigDecimal;
import java.util.*;

/**
 * Выбирает лучшие места для размещения станций, чтобы охватить максимум клиентов.
 */
public class StationPlanner {
    private final List<Client> clients;
    private BigDecimal radiusSquared;

    public StationPlanner(List<Client> clients) {
        this.clients = clients;
    }

    public List<Station> selectBestStations(int stationLimit) {
        BigDecimal r = InputReader.getRadius();
        this.radiusSquared = r.multiply(r);
        List<Station> stations = new ArrayList<>();
        Set<Integer> alreadyCovered = new HashSet<>();

        for (int i = 0; i < stationLimit; i++) {
            Station best = null;

            for (Client center : clients) {
                Set<Integer> covered = new HashSet<>();
                for (Client other : clients) {
                    if (!alreadyCovered.contains(other.index)
                            && center.distanceSquared(other).compareTo(radiusSquared) <= 0) {
                        covered.add(other.index);
                    }
                }

                if (!covered.isEmpty()) {
                    Station candidate = new Station(center.index, covered);
                    if (best == null
                            || candidate.coveredClients.size() > best.coveredClients.size()
                            || (candidate.coveredClients.size() == best.coveredClients.size()
                            && candidate.clientIndex < best.clientIndex)) {
                        best = candidate;
                    }
                }
            }

            if (best == null) break;
            stations.add(best);
            alreadyCovered.addAll(best.coveredClients);
        }

        stations.sort((a, b) -> {
            int cmp = Integer.compare(b.coveredClients.size(), a.coveredClients.size());
            return cmp != 0 ? cmp : Integer.compare(a.clientIndex, b.clientIndex);
        });

        return stations;
    }
}