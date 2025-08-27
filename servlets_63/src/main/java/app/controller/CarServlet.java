package app.controller;

import app.model.Car;
import app.repository.CarRepository;
import app.repository.CarRepositoryDB;
import app.repository.CarRepositoryHibernate;
import app.repository.CarRepositoryMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2025
 */

public class CarServlet extends HttpServlet {

    private CarRepository repository = new CarRepositoryHibernate();

    private ObjectMapper mapper = new ObjectMapper(); // Создаю объект ObjectMapper

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET http://10.2.3.4:8080/cars - все машины
        // GET http://10.2.3.4:8080/cars?id=3&name=petya - одна машина по id из параметров
        // для получения из БД всех или одного автомобиля

        // request - объект запроса. Мз него можно извлечь все, что прислал клиент
        // response - объект ответа, который будет отправлен клиенту, после завершения работы нашего методы
        // Мы можем в response поместить всю информацию, которую хотим передать / отправить клиенту.

        response.setContentType("application/json"); // Устанавливаем тип контента в JSON
        response.setCharacterEncoding("UTF-8"); // Устанавливаем кодировки

        Map<String, String[]> params = request.getParameterMap(); // получить параметры запросы
        // "id" : ["3"]
        // "name" : ["petya"]

        if (params.isEmpty()) {
            // если карта параметров пуста (запрос пришел без параметров) -
            // в ответе отдаю ВСЕ автомобили
            List<Car> cars = repository.getAll();

            String jsonResponse = mapper.writeValueAsString(cars); // Преобразовать список машин в JSON
            response.getWriter().write(jsonResponse); // записываем json-строку в response
//        cars.forEach(car -> {
//            try {
//                response.getWriter().write(car.toString() + "\n");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
        } else {
            // пришли какие-то параметры
            String idString = params.get("id")[0]; // -> "3"
            long id = Long.parseLong(idString);

            // Если я уверен что в запросе будет параметр id и у него будет только 1 значение (не массив)
            String idString2 = request.getParameter("id");  // вернет null, если нет такого параметра в запросе

            Car car = repository.getById(id);

            if (car == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Устанавливаем статус ответа 404
                response.getWriter().write("{\"message\" : \"Car not fond\"}");
            } else {
                String json = mapper.writeValueAsString(car); // Преобразуем объект в json
                response.getWriter().write(json);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // POST http://localhost:8080/cars - одна добавленная машина
        // Сохранение нового автомобиля в БД

        // Получить объект автомобиля из тела запроса
        Car car = mapper.readValue(request.getReader(), Car.class);

        car = repository.save(car);

        response.getWriter().write(mapper.writeValueAsString(car));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Приходить объект в теле запроса.
        // Изменить только цену автомобиля
        // обновление существующего автомобиля

        Car dto =mapper.readValue(req.getReader(), Car.class);

        Car updatedCar = repository.update(dto);

        if (updatedCar == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("{\"message\" : \"Car not fond\"}");
        } else {
            String json = mapper.writeValueAsString(updatedCar);
            resp.getWriter().write(json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Удаление автомобиля из БД по его id
        // id приходит в параметрах запроса

        long id = Long.parseLong(req.getParameter("id"));

        Car car = repository.delete(id);

        if (car == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"message\" : \"Car not fond\"}");
        } else {
            resp.getWriter().write(mapper.writeValueAsString(car));
        }
    }
}
