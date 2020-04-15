package tam.cement.controller.rest;

import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tam.cement.model.Point;
import tam.cement.service.point.interfaces.IPointService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/point")
public class PointControllerREST {


    private final IPointService service;

    @Autowired
    public PointControllerREST(IPointService service) {
        this.service = service;
    }



    @RequestMapping("/get/list")
    List<Point> getAll() throws IOException, TesseractException {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Point get(@PathVariable("id") String id) {
        return service.get(id);
    }

}
