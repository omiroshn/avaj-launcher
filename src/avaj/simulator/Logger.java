package avaj.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private FileWriter fr = null;

    Logger(String file) {
        try {
            this.fr = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String data) {
        try {
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
