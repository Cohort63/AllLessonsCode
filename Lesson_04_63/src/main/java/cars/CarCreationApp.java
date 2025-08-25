package cars;

import cars.dto.CarDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
* @author Sergey Bugaenko
* {@code @date} 22.08.2025
*/

public class CarCreationApp {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {


        List<String> models = List.of("Polo", "Golf", "Tiguan");

        CarDTO carDTO = new CarDTO("VW", 2020, models);

        mapper.writeValue(new File("vw.json"), carDTO);




    }
}
