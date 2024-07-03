package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Brand;
import enigma.rent.car.app.models.Car;
import enigma.rent.car.app.services.BrandServ;
import enigma.rent.car.app.utils.responseWrapper.PageResponseWrapper;
import enigma.rent.car.app.utils.responseWrapper.Res;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brands")
@RestController
@RequiredArgsConstructor
@Validated
public class BrandContro {
    private final BrandServ brandServ;

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String name) {
//        return Res.renderJson(brandServ.findAll(pageable, name), "KETEMU!!!", HttpStatus.OK);
        Page<Brand> res = brandServ.findAll(pageable, name);
        PageResponseWrapper<Brand> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "Success",
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return Res.renderJson(brandServ.findById(id), "Ketemu", HttpStatus.OK);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Brand brand) {
        return Res.renderJson(brandServ.create(brand), "Berhasil di create", HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Brand brand) {
        return Res.renderJson(brandServ.update(id, brand), "Berhasil di update", HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        brandServ.deleteById(id);
        return Res.renderJson(null, "Berhasil di delete", HttpStatus.OK);
    }
}
