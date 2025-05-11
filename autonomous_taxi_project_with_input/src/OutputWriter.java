import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Записывает выходные данные в output.txt.
 */
public class OutputWriter {
    public static void writeStations(String filename, List<Station> stations) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Station station : stations) {
                writer.write(station.clientIndex + " " + station.coveredClients.size());
                writer.newLine();
            }
        }
    }
}