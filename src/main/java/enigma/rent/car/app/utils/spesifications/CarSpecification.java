package enigma.rent.car.app.utils.spesifications;

import enigma.rent.car.app.models.Car;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarSpecification {
    public static Specification<Car> getSpecification(String name, Boolean available) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }
            if (available) {
                predicates.add(criteriaBuilder.isTrue(root.get("available")));
            }

            return criteriaBuilder.and((predicates.toArray(new Predicate[predicates.size()])));
//
        };
    }
}
