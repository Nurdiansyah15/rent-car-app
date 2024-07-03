package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandServ {
    Page<Brand> findAll(Pageable pageable, String name);
    Brand findById(Integer id);
    Brand create(Brand brand);
    Brand update(Integer id, Brand brand);
    void deleteById(Integer id);
}
