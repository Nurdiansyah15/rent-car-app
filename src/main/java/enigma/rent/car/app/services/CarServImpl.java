package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Brand;
import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.repositories.CarRepo;
import enigma.rent.car.app.utils.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServImpl implements CarServ{
    private final CarRepo carRepo;
    private final BrandServ brandServ;

    @Override
    public List<Car> findAll() {
        return carRepo.findAll();
    }

    @Override
    public Car findById(Integer id) {
        return carRepo.findById(id).orElse(null);
    }

    @Override
    public Car create(CarDto car) {
        Brand brand = brandServ.findById(car.getBrand_id());
        Car newCar = Car.builder()
                .name(car.getName())
                .brand(brand)
                .available(car.getAvailable())
                .price(car.getPrice())
                .build();
        return carRepo.save(newCar);
    }

    @Override
    public Car update(Integer id, CarDto req) {
        Car newCar = carRepo.findById(id).orElse(null);
        newCar.setBrand(brandServ.findById(req.getBrand_id()));
        newCar.setName(req.getName());
        newCar.setAvailable(req.getAvailable());
        newCar.setPrice(req.getPrice());
        return carRepo.save(newCar);
    }

    @Override
    public void deleteById(Integer id) {
        carRepo.deleteById(id);
    }
}
