package enigma.rent.car.app.services;

import enigma.rent.car.app.models.User;
import enigma.rent.car.app.repositories.UserRepo;
import enigma.rent.car.app.utils.dto.UserTopupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServImpl implements UserServ{
    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(Integer id, User user) {
        User newUser = userRepo.findById(id).orElse(null);
        if (newUser != null) {
            newUser.setName(user.getName());
            newUser.setBalance(user.getBalance());
            return userRepo.save(newUser);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User topup(Integer id, UserTopupDto user) {
        User userExisting = userRepo.findById(id).orElse(null);
        if (userExisting!=null){
            userExisting.setBalance(userExisting.getBalance()+user.getBalance());
            return userRepo.save(userExisting);
        }
        return null;
    }
}
