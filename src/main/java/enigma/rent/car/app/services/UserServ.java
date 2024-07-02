package enigma.rent.car.app.services;

import enigma.rent.car.app.models.User;
import enigma.rent.car.app.utils.dto.UserTopupDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServ {
    List<User> findAll();

    User findById(Integer id);

    User create(User user);

    User update(Integer id, User user);

    void deleteById(Integer id);

    User topup(Integer id, UserTopupDto user);
}
