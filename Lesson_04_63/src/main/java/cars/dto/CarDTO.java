package cars.dto;

import java.util.List;

/**
* @author Sergey Bugaenko
* {@code @date} 22.08.2025
*/

public class CarDTO {

    private String manufacturer;
    private int year;
    private List<String> models;

    public CarDTO(String manufacturer, int year, List<String> models) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.models = models;
    }

    public CarDTO() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public List<String> getModels() {
        return models;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", models=" + models +
                '}';
    }
}
