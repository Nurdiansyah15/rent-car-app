package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.services.CarServ;
import enigma.rent.car.app.utils.dto.CarDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
@RestController
@RequiredArgsConstructor
@Validated //Required for validation
public class CarContro {
    private final CarServ carServ;

    @GetMapping
    public List<Car> findAll(){
        return carServ.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Integer id){
        return carServ.findById(id);
    }

    @PostMapping
    public Car create(@Valid @RequestBody CarDto car){
        return carServ.create(car);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer id, @Valid @RequestBody CarDto car){
        return carServ.update(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carServ.deleteById(id);
    }

}
