package generics;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

// T E K V

public class GenericBoxInt {

    private Object value;

    public GenericBoxInt(Object value) {
        this.value = value;
    }

    public Integer getValue() {
        return (Integer) value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericBox{" +
                "value=" + value +
                '}';
    }
}
