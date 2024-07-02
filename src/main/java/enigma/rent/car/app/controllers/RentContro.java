package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.services.RentServ;
import enigma.rent.car.app.utils.dto.RentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")

public class RentContro {
    private final RentServ rentService;

    public RentContro(RentServ rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public Rent create(@RequestBody RentDto rent) {
        return rentService.create(rent);
    }

    @GetMapping
    public List<Rent> getAll() {
        return rentService.findAll();
    }

    @GetMapping("/{id}")
    public Rent get(@PathVariable Integer id) {
        return rentService.findById(id);
    }

    @PutMapping("/{id}")
    public Rent update(@PathVariable Integer id) {
        return rentService.update(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rentService.deleteById(id);
    }
}
