package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.services.CarServ;
import enigma.rent.car.app.utils.dto.CarDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
@RestController
@RequiredArgsConstructor
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
    public Car create(@RequestBody CarDTO car){
        return carServ.create(car);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer id, @RequestBody CarDTO car){
        return carServ.update(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        carServ.deleteById(id);
    }

}
