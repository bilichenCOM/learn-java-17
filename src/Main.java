import service.Day;
import service.PrintService;

public class Main {

    public static void main(String[] args) {
        PrintService service = new PrintService();
        Day day = Day.TUESDAY;
        service.print(day);
    }
}
