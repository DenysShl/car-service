package car.util;

import car.dao.CarDao;
import car.service.ReportCarService;
import car.service.impl.CarStrategy;
import java.util.Scanner;

public class MenuOption {
    private final UserChoiceAddCar userChoiceAddCar;
    private final CarStrategy carStrategy;
    private final CarDao carDao;
    private final ReportCarService report;

    public MenuOption(
            CarStrategy carStrategy,
            CarDao carDao,
            UserChoiceAddCar userChoiceAddCar,
            ReportCarService report) {
        this.userChoiceAddCar = userChoiceAddCar;
        this.carStrategy = carStrategy;
        this.carDao = carDao;
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
                    report.print(carDao.getAllCars());
                    break;
                case "2":
                case "3":
                case "4":
                    System.out.println("Add a new car");
                    String newCar = userChoiceAddCar.userSelected(text);
                    carDao.save(carStrategy.getCarCreateService(newCar).getCar(newCar));
                    break;
                case "5":
                    carDao.getAllCars().stream()
                            .map(car -> car.getBrand()).distinct().sorted()
                            .forEach(System.out::println);
                    System.out.println("Show all cars of a particular brand, input brand: ");
                    String brand = reader.nextLine();
                    report.print(carDao.getAllCarsByBrand(brand));
                    break;
                case "6":
                    carDao.getAllCars().stream()
                            .map(car -> car.getCarType().name()).distinct().sorted()
                            .forEach(System.out::println);
                    System.out.println("Show all cars of a particular type, input type: ");
                    String type = reader.nextLine();
                    report.print(carDao.getAllCarsByType(type));
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
