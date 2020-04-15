package tam.cement.service.camera.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tam.cement.dataset.TestData;
import tam.cement.model.Camera;
import tam.cement.service.camera.interfaces.ICameraService;

import java.util.List;

@Service
public class CameraServiceFakeImpl implements ICameraService {

    private final TestData data;

    @Autowired
    public CameraServiceFakeImpl(TestData data) {
        this.data = data;
    }

    @Override
    public Camera create(Camera camera) {
        return this.data.setCamera(camera);
    }

    @Override
    public Camera get(String id) {
        return data.getCamera(id);
    }

    @Override
    public Camera update(Camera camera) {
        return null;
    }

    @Override
    public Camera delete(String id) {
        return data.delete(id);
    }

    @Override
    public List<Camera> getAll() {
        return this.data.getAllCameras();
    }
}
