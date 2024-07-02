package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.repositories.RentRepo;
import enigma.rent.car.app.utils.dto.RentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServImpl implements RentServ {
    private final RentRepo rentRepository;
    private final UserServ userService;

    public RentServImpl(RentRepo rentRepository, UserServ userService) {
        this.rentRepository = rentRepository;
        this.userService = userService;
    }


    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent findById(Integer id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public Rent create(RentDto rent) {
        Rent newRent = new Rent();

        newRent.setUser(userService.findById(rent.getUser_id()));
        newRent.setPrice(rent.getPrice());
        newRent.setEnds_at(rent.getEnds_at());
        newRent.setCar_id(rent.getCar_id());

        rentRepository.save(newRent);

        return newRent;
    }

    @Override
    public Rent update(Integer id, RentDto user) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        rentRepository.deleteById(id);
    }
}


