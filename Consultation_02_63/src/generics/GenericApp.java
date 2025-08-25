package generics;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public class GenericApp {

    public static void main(String[] args) {

        GenericBox<String> box = new GenericBox<>("Hello");

        GenericBox<Integer> box2 = new GenericBox<>(123);

      //  box.setValue(152); // Проверка типизации

        String val = box.getValue();

        Integer v = box2.getValue();

      //  GenericBox<int> intBox = new GenericBox<>();

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        Integer[] arr = list.toArray(new Integer[0]);

    }
}
