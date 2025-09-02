package staticBlock;

import utils.MathUtil;

import java.util.Arrays;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2025
 */

public class StaticApp {

    public static void main(String[] args) {


        System.out.println("static counter: " + StaticBlockDemo.counter);
//        System.out.println("static array: " + Arrays.toString(StaticBlockDemo.colors));

        StaticBlockDemo demo = new StaticBlockDemo("Demo", 55);
        System.out.println(demo);

        System.out.println("===================\n");

        StaticBlockDemo demo2 = new StaticBlockDemo("Demo2");
        System.out.println(demo2);

        System.out.println("===================\n");

        int sum = MathUtil.sumIntegers(1, 3, 4);
        System.out.println("sum: " + sum);

        sum = MathUtil.sumIntegers(1, 2, 3, 4, 5, 6, 7, 8, 9);;





    }
}
