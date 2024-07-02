package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.models.User;
import enigma.rent.car.app.repositories.CarRepo;
import enigma.rent.car.app.repositories.RentRepo;
import enigma.rent.car.app.repositories.UserRepo;
import enigma.rent.car.app.utils.dto.RentDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentServImpl implements RentServ {
    private final RentRepo rentRepository;
    private final UserServ userService;
    private final CarServ carService;
    private final UserRepo userRepo;
    private final CarRepo carRepo;

    public RentServImpl(RentRepo rentRepository, CarServ carServ, UserServ userService, UserRepo userRepo, CarRepo carRepo) {
        this.rentRepository = rentRepository;
        this.userService = userService;
        this.carService = carServ;
        this.userRepo = userRepo;
        this.carRepo = carRepo;
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
        Car existingCar = carService.findById(rent.getCar_id());

        newRent.setUser(userService.findById(rent.getUser_id()));
        newRent.setPrice(existingCar.getPrice());
        newRent.setEnds_at(rent.getEnds_at());
        newRent.setCar(existingCar);
        existingCar.setAvailable(false);

        carRepo.save(existingCar);
        rentRepository.save(newRent);

        return newRent;
    }

    @Override
    public Rent update(Integer id) {
        Rent targetRent = rentRepository.findById(id).orElse(null);
        User targetUser = targetRent.getUser();
        Car targetCar = targetRent.getCar();
        LocalDate skrg = LocalDate.now();

        if (targetRent.getEnds_at().isBefore(skrg)) {
            targetUser.setBalance(targetUser.getBalance() - targetRent.getPrice() + (targetRent.getPrice() * 10 / 100) );

        } else if(targetRent.getEnds_at().isAfter(skrg)){
            targetUser.setBalance(targetUser.getBalance() - targetRent.getPrice());

        }
        targetRent.setCompleted(true);
        targetCar.setAvailable(true);

        userRepo.save(targetUser);
        carRepo.save(targetCar);
        return rentRepository.save(targetRent);
    }

    @Override
    public void deleteById(Integer id) {
        rentRepository.deleteById(id);
    }
}