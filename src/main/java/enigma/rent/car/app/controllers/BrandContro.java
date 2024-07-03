package enigma.rent.car.app.controllers;

import enigma.rent.car.app.models.Brand;
import enigma.rent.car.app.services.BrandServ;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public List<Brand> findAll(){
        return brandServ.findAll();
    }
    @GetMapping("/{id}")
    public Brand findById(@PathVariable Integer id){
        return brandServ.findById(id);
    }

    //CREATE
    @PostMapping
    public Brand create(@Valid @RequestBody Brand brand){
        return brandServ.create(brand);
    }

    //UPDATE
    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @Valid @RequestBody Brand brand){
        System.out.println("Success Update");
        return brandServ.update(id, brand);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println("Delete Success");
        brandServ.deleteById(id);
    }
}
