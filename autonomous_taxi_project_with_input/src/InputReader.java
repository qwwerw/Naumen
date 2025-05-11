import java.io.*;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.*;

/**
 * Чтение входных данных из input.txt.
 */
public class InputReader {
    private static BigDecimal radius;

    public static List<Client> readClients(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        String[] header = lines.get(0).trim().split(" ");
        int n = Integer.parseInt(header[0]);
        radius = new BigDecimal(header[1]);

        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] coords = lines.get(i + 1).trim().split(" ");
            BigDecimal x = new BigDecimal(coords[0]);
            BigDecimal y = new BigDecimal(coords[1]);
            clients.add(new Client(i, x, y));
        }
        return clients;
    }

    public static BigDecimal getRadius() {
        return radius;
    }
}