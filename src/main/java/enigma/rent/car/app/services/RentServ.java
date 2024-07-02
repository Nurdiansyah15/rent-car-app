package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.utils.dto.RentDto;

import java.util.List;

public interface RentServ {
    List<Rent> findAll();
    Rent findById(Integer id);
    Rent create(RentDto rent);
    Rent update(Integer id, RentDto user);
    void deleteById(Integer id);
}
