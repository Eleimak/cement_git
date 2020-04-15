package tam.cement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tam.cement.model.Processing;

@Repository
public interface ProcessingRepository extends MongoRepository<Processing, String> {
}
