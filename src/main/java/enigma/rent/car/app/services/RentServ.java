package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.utils.dto.RentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RentServ {
    Page<Rent> findAll(Pageable pageable);
    Rent findById(Integer id);
    Rent create(RentDto rent);
    Rent update(Integer id);
    void deleteById(Integer id);
}
