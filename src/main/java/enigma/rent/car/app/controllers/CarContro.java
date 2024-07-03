package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.models.User;
import enigma.rent.car.app.services.CarServ;
import enigma.rent.car.app.utils.dto.CarDto;
import enigma.rent.car.app.utils.responseWrapper.PageResponseWrapper;
import enigma.rent.car.app.utils.responseWrapper.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cars")
@RestController
@RequiredArgsConstructor
public class CarContro {
    private final CarServ carServ;

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String name, @RequestParam(required = false) Boolean available) {
//        return Res.renderJson(carServ.findAll(pageable, name, available), "KETEMU!!!", HttpStatus.OK);
        Page<Car> res = carServ.findAll(pageable, name, available);
        PageResponseWrapper<Car> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "Success",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {

        return Res.renderJson(carServ.findById(id), "KETEMU!!!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CarDto car) {

        return Res.renderJson(carServ.create(car), "Berhasil di create!!!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CarDto car) {
        return Res.renderJson(carServ.update(id, car), "Berhasil di update!!!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        carServ.deleteById(id);
        return Res.renderJson(null, "Berhasil di delete!!!", HttpStatus.OK);
    }

}
