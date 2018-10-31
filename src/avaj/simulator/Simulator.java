package avaj.simulator;

import avaj.simulator.vehicles.AircraftFactory;
import avaj.simulator.vehicles.Flyable;
import avaj.simulator.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(args[0]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations <= 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    String[] newLine = line.split(" ");
                    Flyable flyable = AircraftFactory.newAircraft(
                            newLine[0],
                            newLine[1],
                            Integer.parseInt(newLine[2]),
                            Integer.parseInt(newLine[3]),
                            Integer.parseInt(newLine[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify simulation file");
        }
//         finally {
//            Logger.getLogger().close();
//        }
        System.out.println("All good");
    }
}
