package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.User;
import enigma.rent.car.app.services.UserServ;
import enigma.rent.car.app.utils.dto.UserTopupDto;
import enigma.rent.car.app.utils.responseWrapper.Res;
import enigma.rent.car.app.utils.responseWrapper.WebResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@Validated
public class UserContro {
    private final UserServ userServ;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return Res.renderJson(userServ.findAll(),"KETEMU!!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return Res.renderJson(userServ.findById(id),"KETEMU!!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        return Res.renderJson(userServ.create(user),"Berhasil dibuat!!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody User user) {
        return Res.renderJson(userServ.update(id, user),"UPDATED MWEHEHEHE!!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        userServ.deleteById(id);
        return Res.renderJson(null, "Berhasil Delete", HttpStatus.OK);
    }

    @PutMapping("/topup/{id}")
    public ResponseEntity<?> topup(@PathVariable Integer id, @RequestBody UserTopupDto user) {
        if (userServ.topup(id, user) == null) {
            return Res.renderJson(null, "User Not Found", HttpStatus.BAD_REQUEST);
        }else {
            return Res.renderJson(userServ.topup(id, user), "Popup Success", HttpStatus.OK);
        }
    }
}
