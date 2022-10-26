package car.dao.impl;

import car.dao.CarDao;
import car.model.Car;
import car.model.enums.CarType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CarDaoImpl implements CarDao {
    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car save(Car car) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can`t save car to DB " + car, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Car> getAllCars() {
        try (Session session = sessionFactory.openSession()) {
            Query<Car> carQuery = session.createQuery("SELECT c FROM Car c", Car.class);
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can`t find cars!", e);
        }
    }

    @Override
    public List<Car> getAllCarsByBrand(String brand) {
        try (Session session = sessionFactory.openSession()) {
            Query<Car> carQuery = session.createQuery(
                    "FROM Car c WHERE UPPER(c.brand) LIKE CONCAT(:brand, '%')", Car.class);
            carQuery.setParameter("brand", brand.toUpperCase());
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can`t find cars by brand: " + brand, e);
        }
    }

    @Override
    public List<Car> getAllCarsByType(String type) {
        try (Session session = sessionFactory.openSession()) {
            Query<Car> carQuery = session.createQuery(
                    "FROM Car WHERE carType = :cartype", Car.class);
            carQuery.setParameter("cartype", CarType.valueOf(type.toUpperCase()));
            return carQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can`t find cars by type: " + type, e);
        }
    }
}
