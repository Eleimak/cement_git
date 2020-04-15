package tam.cement.controller.web;

import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tam.cement.model.Point;
import tam.cement.service.point.interfaces.IPointService;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/web/point")
public class PointControllerWEB {

    @Autowired
    IPointService service;

    @RequestMapping("/get/list")
    String showAll(Model model) throws IOException, TesseractException {
        
        List<Point> list = service.getAll();
        model.addAttribute("list", list);
        return "pointList";
        
    }

    @RequestMapping("/get/{id}")
    String show(@PathVariable("id") String id) {
        return null;
    }

}
