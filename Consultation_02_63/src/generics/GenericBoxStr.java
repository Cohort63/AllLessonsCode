package generics;

/**
 * @author Sergey Bugaenko
 * {@code @date} 21.08.2025
 */

// T E K V

public class GenericBoxStr  {

    private String value;

    public GenericBoxStr(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericBox{" +
                "value=" + value +
                '}';
    }
}
