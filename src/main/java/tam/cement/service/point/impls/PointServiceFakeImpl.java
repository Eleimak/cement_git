package tam.cement.service.point.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tam.cement.dataset.TestData;
import tam.cement.model.Point;
import tam.cement.service.point.interfaces.IPointService;

import java.util.List;

@Service("Fake")
public class PointServiceFakeImpl implements IPointService {

  @Autowired
  TestData data;

    @Override
    public Point create(Point point) {
        return this.data.setPoint(point);
    }

    @Override
    public Point get(String id) {

        return this.data.getPoints().stream().filter(point -> point.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Point update(Point point) {
        return null;
    }

    @Override
    public Point delete(String id) {
        return null;
    }

    @Override
    public List<Point> getAll() {
        return this.data.getPoints();
    }
}
