package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.services.RentServ;
import enigma.rent.car.app.utils.dto.RentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
