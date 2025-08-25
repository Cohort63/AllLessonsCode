package generics;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

public class SimpleApp {

    public static void main(String[] args) {

        SimpleBox box1 = new SimpleBox(10);

        System.out.println(box1);

        SimpleBox box2 = new SimpleBox(20);

        int sum = (int) box1.getValue() + (int) box2.getValue();

        System.out.println("sum: " + sum);

        SimpleBox[] boxes = new SimpleBox[3];
        boxes[0] = box1;
        boxes[1] = box2;
        boxes[2] = new SimpleBox("30");

        sum = 0;
        for (SimpleBox box : boxes) {
            sum += (int) box.getValue();
        }

        System.out.println("sum: " + sum);

        int value = (int) box1.getValue();
    }
}
