package tam.cement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tam.cement.model.Camera;

@Repository
public interface CameraRepository extends MongoRepository<Camera, String> {
}
