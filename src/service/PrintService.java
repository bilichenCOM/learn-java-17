package service;

import device.Device;
import device.Fax;
import device.Printer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintService {
    private final Map<Day, List<Device>> devicesDayMap;

    public PrintService() {
        devicesDayMap = new HashMap<>();
        devicesDayMap.put(Day.MONDAY, Collections.singletonList(new Printer()));
        devicesDayMap.put(Day.TUESDAY, Collections.emptyList());
        devicesDayMap.put(Day.WEDNESDAY, Collections.singletonList(new Fax()));
    }

    public void print(Day day) {
        Device availableDevice = devicesDayMap.get(day).stream()
                .findFirst().orElseThrow(() -> new RuntimeException("no device on that day"));
        availableDevice
                .print(String.join(" ", "Today is: ", day.toString(), "; sent from: ", availableDevice.getName()));
    }
}
