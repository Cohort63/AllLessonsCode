package maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Bugaenko
 * {@code @date} 04.09.2025
 */

public class MapApp {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(3, "red");
        map.put(0, "white");
        map.put(17, "black");
        map.put(19, "blue");
        map.put(19, "green");

        System.out.println(map);

        String value = map.get(3);

        System.out.println(Integer.valueOf(-1552).hashCode());

    }
}
