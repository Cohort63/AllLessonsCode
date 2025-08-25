package app.controller;

import app.repository.CarRepository;
import app.repository.CarRepositoryMap;
import jakarta.servlet.http.HttpServlet;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2025
 */

public class CarServlet extends HttpServlet {

    private CarRepository repository = new CarRepositoryMap();

    // GET http://10.2.3.4:8080/cars
}
