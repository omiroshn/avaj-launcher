package ro.academyplus.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class Simulator {
//    private static WeatherTower weatherTower;
//    private static List<Flyable> flyables = new ArrayList<Flyable>();

    public static void main(String[] args) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
//                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                System.out.println(simulations);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
//                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
//                            line.split(" ")[2], line.split(" ")[3], line.split(" ")[4]);
//                    flyable.add(flyable);
                }

//                for (Flyable flyable : flyables) {
//                    flyable.registerTower(weatherTower);
//                }
//
//                for (int i = 1; i <= simulations; i++) {
//                    weatherTower.changeWeather();
//                }
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

    }
}