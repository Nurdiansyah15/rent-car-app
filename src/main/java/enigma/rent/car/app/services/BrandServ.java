package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandServ {
    List<Brand> findAll();
    Brand findById(Integer id);
    Brand create(Brand brand);
    Brand update(Integer id, Brand brand);
    void deleteById(Integer id);
}
