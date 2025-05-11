import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Точка входа в программу. Читает input.txt, вычисляет расположение станций и пишет output.txt.
 */
public class Main {
    public static void main(String[] args) {
        try {
            List<Client> clients = InputReader.readClients("input.txt");
            int stationLimit = 10;
            StationPlanner planner = new StationPlanner(clients);
            List<Station> stations = planner.selectBestStations(stationLimit);
            OutputWriter.writeStations("output.txt", stations);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка выполнения программы: " + e.getMessage(), e);
        }
    }
}