package avaj.weather;

import avaj.exceptions.ParseFileException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) throws ParseFileException {
        if (longitude > 0) {
            this.longitude = longitude;
        } else {
            throw new ParseFileException("Longitude is below 0.");
        }
        if (latitude > 0) {
            this.latitude = latitude;
        } else {
            throw new ParseFileException("Latitude is below 0.");
        }
        if (height > 0) {
            this.height = height;
        } else {
            throw new ParseFileException("Height is below 0.");
        }
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
