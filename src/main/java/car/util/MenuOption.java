package car.util;

import car.service.CarParseService;
import car.service.CarSaveService;
import car.service.GenerateReportsCarService;
import car.service.ReportCarService;
import car.storage.Storage;
import java.util.Scanner;

public class MenuOption {
    private final GenerateReportsCarService generateReportsCarService;
    private final UserChoiceAddCar userChoiceAddCar;
    private final CarParseService carParseService;
    private final CarSaveService carSaveService;
    private final ReportCarService report;

    public MenuOption(GenerateReportsCarService generateReportsCarService,
                      UserChoiceAddCar userChoiceAddCar,
                      CarParseService carParseService,
                      CarSaveService carSaveService, ReportCarService report) {
        this.generateReportsCarService = generateReportsCarService;
        this.userChoiceAddCar = userChoiceAddCar;
        this.carParseService = carParseService;
        this.carSaveService = carSaveService;
        this.report = report;
    }

    public void getOption(Scanner reader) {
        String text = "";
        do {
            System.out.println(System.lineSeparator()
                    + "Please make your choice:" + System.lineSeparator()
                    + "   1. Show the entire cars catalog" + System.lineSeparator()
                    + "   2. Add a new high-speed car" + System.lineSeparator()
                    + "   3. Add a new electric car" + System.lineSeparator()
                    + "   4. Add a new pickup car" + System.lineSeparator()
                    + "   5. Show all cars of a particular brand" + System.lineSeparator()
                    + "   6. Show all cars of a particular type" + System.lineSeparator()
                    + "   7. Stop the program" + System.lineSeparator()
                    + " Input number: "
            );
            text = reader.nextLine();
            switch (text) {
                case "1":
                    System.out.println("Show the entire cars catalog");
                    report.print(generateReportsCarService.getAllCarsReport());
                    break;
                case "2":
                case "3":
                case "4":
                    System.out.println("Add a new car");
                    String newCar = userChoiceAddCar.userSelected(text);
                    carSaveService.saveCarToStorage(carParseService.parseToCar(newCar));
                    break;
                case "5":
                    Storage.cars.stream()
                            .map(car -> car.getBrand()).distinct().sorted()
                            .forEach(System.out::println);
                    System.out.println("Show all cars of a particular brand, input brand: ");
                    String brand = reader.nextLine();
                    report.print(generateReportsCarService.getAllCarsByBrand(brand));
                    break;
                case "6":
                    Storage.cars.stream().map(car -> car.getCarType().name()).distinct().sorted()
                            .forEach(System.out::println);
                    System.out.println("Show all cars of a particular type, input type: ");
                    String type = reader.nextLine();
                    report.print(generateReportsCarService.getAllCarsByType(type));
                    break;
                case "7":
                    text = "exit";
                    break;

                default:
                    System.out.println("You can use number 1-7, repeat please your choice");
            }
        } while (text != "exit");
    }
}
