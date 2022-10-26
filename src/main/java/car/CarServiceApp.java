package car;

import car.dao.CarDao;
import car.dao.impl.CarDaoImpl;
import car.service.FileReaderService;
import car.service.ReportCarService;
import car.service.impl.CarStrategy;
import car.service.impl.FileReaderServiceImpl;
import car.service.impl.ReportCarServiceImpl;
import car.util.HibernateUtil;
import car.util.MenuOption;
import car.util.UserChoiceAddCar;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.hibernate.SessionFactory;

public class CarServiceApp {
    private static final String INPUT_FILE_NAME = "src/main/resources/cars.txt";
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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

        CarDao carDao = new CarDaoImpl(sessionFactory);
        CarStrategy carStrategy = new CarStrategy();
        for (String stringCar : lines) {
            carDao.save(carStrategy.getCarCreateService(stringCar).getCar(stringCar));
        }

        UserChoiceAddCar choiceService = new UserChoiceAddCar(scanner);
        ReportCarService report = new ReportCarServiceImpl();
        MenuOption menu = new MenuOption(
                carStrategy,
                carDao,
                choiceService,
                report);
        menu.getOption(scanner);
    }
}
