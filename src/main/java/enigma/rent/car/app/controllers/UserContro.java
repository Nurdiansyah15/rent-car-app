package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.User;
import enigma.rent.car.app.services.UserServ;
import enigma.rent.car.app.utils.dto.UserTopUpDto;
import enigma.rent.car.app.utils.responseWrapper.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserContro {
    private final UserServ userServ;

    @GetMapping
    public List<User> findAll() {
        return userServ.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userServ.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userServ.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        return userServ.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userServ.deleteById(id);
    }

    @PutMapping("/topup/{id}")
    public @ResponseBody ResponseWrapper topup(@PathVariable Integer id, @RequestBody UserTopUpDto user) {
        if (userServ.topup(id, user) == null) {
            return new ResponseWrapper(400, "User Not Found", null);
        }else {
            return new ResponseWrapper(200, "Popup Success", userServ.topup(id, user));
        }
    }
}
