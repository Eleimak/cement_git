package tam.cement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tam.cement.model.Cadr;

@Repository
public interface CadrRepository extends MongoRepository<Cadr, String> {
}
