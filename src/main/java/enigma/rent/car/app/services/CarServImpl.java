package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Brand;
import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.repositories.CarRepo;
import enigma.rent.car.app.utils.dto.CarDto;
import enigma.rent.car.app.utils.spesifications.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServImpl implements CarServ {
    private final CarRepo carRepo;
    private final BrandServ brandServ;

    @Override
    public Page<Car> findAll(Pageable pageable, String name, Boolean available) {
        Specification<Car> specification = Specification.where(null);
        if (name != null && !name.isEmpty()) {
            specification = specification.and(CarSpecification.searchCarByName(name));
        }
        if (available != null) {
            specification = specification.and(CarSpecification.isCarAvailable(available));
        }

        // YOU CAN ADD MORE SPECIFICATIONS HERE

        if (specification != null) {
            return carRepo.findAll(pageable, specification);
        } else {
            return carRepo.findAll(pageable);
        }

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
