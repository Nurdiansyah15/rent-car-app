package enigma.rent.car.app.repositories;

import enigma.rent.car.app.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepo extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {
}
