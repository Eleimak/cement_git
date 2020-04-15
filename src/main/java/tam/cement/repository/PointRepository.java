package tam.cement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tam.cement.model.Point;

@Repository
public interface PointRepository extends MongoRepository<Point, String> {
}
