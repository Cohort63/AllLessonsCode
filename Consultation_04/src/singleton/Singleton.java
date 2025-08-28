package singleton;

/**
 * @author Sergey Bugaenko
 * {@code @date} 28.08.2025
 */

public class Singleton {


    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

}
