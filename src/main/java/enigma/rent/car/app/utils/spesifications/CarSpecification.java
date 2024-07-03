package enigma.rent.car.app.utils.spesifications;

import enigma.rent.car.app.models.Car;
import org.springframework.data.jpa.domain.Specification;

public class CarSpecification {

    public static Specification<Car> searchCarByName(String name) {
        return (root, query, criteriaBuilder) -> ( criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }

    public static Specification<Car> isCarAvailable(Boolean available) {
        return (root, query, criteriaBuilder) -> ( criteriaBuilder.equal(root.get("available"), available));
    }
}
