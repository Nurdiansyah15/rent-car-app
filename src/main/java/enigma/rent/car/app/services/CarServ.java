package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.utils.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarServ {
    List<Car> findAll();

    Car findById(Integer id);

    Car create(CarDTO car);

    Car update(Integer id, CarDTO car);

    void deleteById(Integer id);
}
