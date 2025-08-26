package app.constants;

/**
 * @author Sergey Bugaenko
 * {@code @date} 26.08.2025
 */

public interface Constants {

    /*
    http://localhost:8080/cars?id=5
    jdbc:postgresql://localhost:5432/g_63_cars?user=postgres&password=pos1234
     */

    String DB_DRIVER_PATH = "org.postgresql.Driver";
    String DB_ADDRESS = "jdbc:postgresql://localhost:5432/";
    String DB_NAME = "g_63_cars";
    String DB_USER = "my_user";
    String DB_PASSWORD = "pos1234";

}
