package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Rent;
import enigma.rent.car.app.services.RentServ;
import enigma.rent.car.app.utils.dto.RentDto;
import enigma.rent.car.app.utils.responseWrapper.Res;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(@RequestBody RentDto rent) {
        return Res.renderJson(rentService.create(rent), "Berhasil di create!!!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return Res.renderJson(rentService.findAll(pageable), "Berhasil di create!!!", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        return Res.renderJson(rentService.findById(id), "Berhasil di create!!!", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id) {
        return Res.renderJson(rentService.update(id), "Berhasil di create!!!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        rentService.deleteById(id);
        return Res.renderJson(null, "Berhasil di create!!!", HttpStatus.OK);
    }
}
