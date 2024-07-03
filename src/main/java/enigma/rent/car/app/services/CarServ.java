package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.utils.dto.CarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CarServ {
    Page<Car> findAll(Pageable pageable, Boolean available);

    Car findById(Integer id);

    Car create(CarDto car);

    Car update(Integer id, CarDto car);

    void deleteById(Integer id);
}
