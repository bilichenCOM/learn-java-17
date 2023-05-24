package device;

import service.Day;

import java.util.List;

public class Fax implements Device{

    private static final String name = "Fax";

    @Override
    public String getName() {
        return name;
    }
}
