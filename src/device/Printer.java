package device;


public class Printer implements Device {


    private static final String name = "Printer";

    @Override
    public String getName() {
        return name;
    }
}
