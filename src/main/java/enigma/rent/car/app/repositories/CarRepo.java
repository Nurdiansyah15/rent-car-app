package enigma.rent.car.app.repositories;

import enigma.rent.car.app.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> , JpaSpecificationExecutor<Car> {
}
