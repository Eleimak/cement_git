package tam.cement.controller.rest;

import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tam.cement.model.Processing;
import tam.cement.service.processing.impls.ProcessingServiceFakeImpl;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/processing")
public class ProcessingControllerREST {

    @Autowired
    ProcessingServiceFakeImpl service;

    @RequestMapping("/get/list")
    List<Processing> getAll() throws IOException, TesseractException {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Processing get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping("/test")
    String success() throws IOException, TesseractException {
        return service.identifyOne("pf04.png");
    }

    @RequestMapping("/list")
    List<Processing> processAll() throws IOException, TesseractException {
        return service.identifyDirectory();
    }

}
