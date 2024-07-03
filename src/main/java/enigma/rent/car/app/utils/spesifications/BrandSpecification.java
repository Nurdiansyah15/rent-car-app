package enigma.rent.car.app.utils.spesifications;

import enigma.rent.car.app.models.Brand;
import org.springframework.data.jpa.domain.Specification;

public class BrandSpecification {
    public static Specification<Brand> searchCarByName(String name) {
        return (root, query, criteriaBuilder) -> ( criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
}
