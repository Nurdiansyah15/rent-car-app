package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.utils.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CarServ {
    List<Car> findAll();

    Car findById(Integer id);

    Car create(CarDto car);

    Car update(Integer id, CarDto car);

    void deleteById(Integer id);
}
