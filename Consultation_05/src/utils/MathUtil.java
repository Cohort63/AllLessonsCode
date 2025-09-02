package utils;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2025
 */

public class MathUtil {




    public static int sumIntegers(int... numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }


}
