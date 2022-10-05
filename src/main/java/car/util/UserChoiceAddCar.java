package car.util;

import car.model.enums.CarType;
import car.model.enums.DriverType;
import java.util.Scanner;

public class UserChoiceAddCar {
    private final Scanner scanner;

    public UserChoiceAddCar(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userSelected(String selection) {
        StringBuilder builder = new StringBuilder();
        double acceleration = 0;
        int speed = 0;
        int range = 0;
        int battery = 0;
        int warranty = 0;
        double fuel = 0;
        DriverType driverType;
        System.out.println("Input brand, for example 'BMW': ");
        String brand = scanner.nextLine();
        System.out.println("Input model, for example 'X5': ");
        String model = scanner.nextLine();

        while (true) {
            System.out.println("Input acceleration for example '7.1': ");
            try {
                acceleration = Double.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(("Wrong number format, you should input number"));
            }
        }
        while (true) {
            System.out.println("Input speed, for example '260': ");
            try {
                speed = Integer.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(("Wrong number format, you should input number"));
            }
        }
        switch (selection) {
            case "2":
                builder.append(CarType.HIGH_SPEED);
                while (true) {
                    System.out.println("Input driver type, for example 'AWD','RWD' or 'FWD': ");
                    try {
                        driverType = DriverType.valueOf(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(("Wrong number format, you should input number"));
                    }
                }
                System.out.println("Input gear box, for example '8-speed': ");
                String gearBox = scanner.nextLine();
                builder.append(" ").append(brand).append(";").append(model).append(';')
                        .append(acceleration).append(";").append(speed).append(";")
                        .append(driverType).append(";").append(gearBox);
                return builder.toString();
            case "3":
                builder.append(CarType.ELECTRIC);
                while (true) {
                    System.out.println("Input range, for example '350': ");
                    try {
                        range = Integer.valueOf(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(("Wrong number format, you should input number"));
                    }
                }
                while (true) {
                    System.out.println("Input battery capacity, for example '75': ");
                    try {
                        battery = Integer.valueOf(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(("Wrong number format, you should input number"));
                    }
                }
                while (true) {
                    System.out.println("Input warranty, for example '7': ");
                    try {
                        warranty = Integer.valueOf(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(("Wrong number format, you should input number"));
                    }
                }
                builder.append(" ").append(brand).append(";").append(model).append(';')
                        .append(acceleration).append(";").append(speed).append(";")
                        .append(range).append(";").append(battery).append(";").append(warranty);
                return builder.toString();
            case "4":
                builder.append(CarType.PICKUP);
                while (true) {
                    System.out.println("Input fuel consumption, for example '14.5': ");
                    try {
                        fuel = Double.valueOf(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(("Wrong number format, you should input number"));
                    }
                }
                builder.append(" ").append(brand).append(";").append(model).append(';')
                        .append(acceleration).append(";").append(speed).append(";")
                        .append(fuel);
                return builder.toString();

            default:
                return "Car type is not exist";
        }
    }
}
