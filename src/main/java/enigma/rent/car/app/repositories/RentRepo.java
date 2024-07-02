package enigma.rent.car.app.repositories;

import enigma.rent.car.app.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepo extends JpaRepository<Rent, Integer> {

}
