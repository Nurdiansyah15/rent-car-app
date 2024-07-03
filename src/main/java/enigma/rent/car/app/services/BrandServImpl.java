package enigma.rent.car.app.services;

import enigma.rent.car.app.models.Brand;
import enigma.rent.car.app.repositories.BrandRepo;
import enigma.rent.car.app.utils.spesifications.BrandSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServImpl implements BrandServ {
    private final BrandRepo brandRepo;

    @Override
    public Page<Brand> findAll(Pageable pageable, String name) {
        Specification<Brand> specification = Specification.where(null);
        if (name != null && !name.isEmpty()) {
            specification = specification.and(BrandSpecification.searchCarByName(name));
        }

        // YOU CAN ADD MORE SPECIFICATIONS HERE

        if (specification != null) {
            return brandRepo.findAll(pageable, specification);
        } else {
            return brandRepo.findAll(pageable);
        }
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepo.findById(id).orElse(null);
    }

    @Override
    public Brand create(Brand brand) {
        return brandRepo.save(brand);
    }

    @Override
    public Brand update(Integer id, Brand brand) {
        Brand newBrand = brandRepo.findById(id).orElse(null);
        if (newBrand != null){
            newBrand.setName(brand.getName());
            return brandRepo.save(newBrand);
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        brandRepo.deleteById(id);
    }
}
