package device;

import service.Day;

public interface Device {
    default void print(String txt) {
        System.out.println(txt);
    }

    String getName();
}
