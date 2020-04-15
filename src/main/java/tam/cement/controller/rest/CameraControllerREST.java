package tam.cement.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tam.cement.model.Camera;
import tam.cement.service.camera.impls.CameraServiceFakeImpl;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/camera")
public class CameraControllerREST {

    private final CameraServiceFakeImpl serviceFake;

    @Autowired
    public CameraControllerREST(CameraServiceFakeImpl serviceFake) {
        this.serviceFake = serviceFake;
    }

    @RequestMapping("/get/list")
    List<Camera> getAll() {
        return serviceFake.getAll();
    }

    @RequestMapping("/get/{id}")
    Camera get(@PathVariable("id") String id) {
        return serviceFake.get(id);
    }

    @PostMapping("/create")
    Camera create(@RequestBody Camera camera) {
        return serviceFake.create(camera);
    }

    @GetMapping("/delete/{id}")
    public Camera delete(@PathVariable("id")String id){
        return serviceFake.delete(id);
    }
}
