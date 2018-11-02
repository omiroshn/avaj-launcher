package avaj.simulator;

import avaj.exceptions.MD5_Exception;
import avaj.simulator.vehicles.AircraftFactory;
import avaj.simulator.vehicles.Flyable;
import avaj.exceptions.ParseFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Simulator {
    private static List<Flyable> flyables = new ArrayList<>();
    private static Logger file = new Logger("simulation.txt");
    private static MD5_Parser myMd5 = new MD5_Parser();

    public static void main(String[] args) {
        try {
            if (args[0].isEmpty())
                throw new FileNotFoundException("File not found");
            if (args.length > 1) {
                myMd5.loadFile(args[0]);
                myMd5.checkString(args[1].toLowerCase());
            }
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                WeatherTower weatherTower = new WeatherTower();
                if (line.split(" ")[0].isEmpty()) {
                    throw new ParseFileException("Simulations line is empty.");
                }
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations <= 0) {
                    throw new ParseFileException("Invalid simulations count.");
                }
                while ((line = reader.readLine()) != null) {
                    String[] newLine = line.split(" ");
                    if (newLine[2].isEmpty() || newLine[3].isEmpty() || newLine[4].isEmpty())
                        throw new ParseFileException("Params are empty.");
                    if (Integer.parseInt(newLine[2]) < 0)
                        throw new ParseFileException("Longitude is below 0.");
                    if (Integer.parseInt(newLine[3]) < 0)
                        throw new ParseFileException("Latitude is below 0.");
                    if (Integer.parseInt(newLine[4]) < 0)
                        throw new ParseFileException("Height is below 0.");
                    Flyable flyable = AircraftFactory.newAircraft(
                            newLine[0],
                            newLine[1],
                            Integer.parseInt(newLine[2]),
                            Integer.parseInt(newLine[3]),
                            Integer.parseInt(newLine[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower, file);
                }

                for (int i = 1; i <= simulations; i++) {
                    file.writeToFile("Weather has changed! Iteration " + i + "\n");
                    weatherTower.changeWeather();
                }

                file.closeFile();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (Objects.equals(e.getMessage(), "4"))
                System.out.println("ArrayIndexOutOfBoundsException: Empty Parameter");
            else
                System.out.println("ArrayIndexOutOfBoundsException: Empty Line");
        } catch (ParseFileException e) {
            System.out.println("ParseFileException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (MD5_Exception e) {
            System.out.println("MD5_Exception: " + e.getMessage());
        }
    }
}
