package tam.cement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tam.cement.model.Generic;

@Repository
public interface GenericRepository extends MongoRepository<Generic, String> {
}
