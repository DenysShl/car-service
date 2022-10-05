package car;

import car.service.FileReaderService;
import car.service.GenerateReportsCarService;
import car.service.ParseService;
import car.service.PrintReport;
import car.service.impl.FileReaderServiceImpl;
import car.service.impl.GenerateReportsCarServiceImpl;
import car.service.impl.ParseServiceImpl;
import car.service.impl.PrintReportImpl;
import car.util.MenuOption;
import car.util.UserChoiceAddCar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CarServiceApp {
    private static final String INPUT_FILE_NAME = "src/main/resources/cars.txt";

    public static void main(String[] args) {
        System.out.println("Start car service: "
                + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("If you want use default path and file name"
                + " 'src/main/resources/cars.txt'"
                + " input any keys,"
                + " if you want used your file - enter number '1':");
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String fileName = "";
        if (nextLine.equals("1")) {
            System.out.println("Input path and file name: ");
            fileName = scanner.nextLine();
        } else {
            fileName = INPUT_FILE_NAME;
        }

        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> lines = readerService.readFromFile(fileName);

        ParseService parseService = new ParseServiceImpl();
        parseService.parseCarToStorage(lines);

        GenerateReportsCarService generateReportsCarService = new GenerateReportsCarServiceImpl();
        UserChoiceAddCar choiceService = new UserChoiceAddCar(scanner);
        PrintReport report = new PrintReportImpl();

        MenuOption menu = new MenuOption(
                generateReportsCarService,
                choiceService,
                parseService,
                report);
        menu.getOption(scanner);
    }
}
