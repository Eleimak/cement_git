package tam.cement.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tam.cement.model.Cadr;
import tam.cement.service.cadr.impls.CadrServiceFakeImpl;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cadr")
public class CadrControllerREST {

    @Autowired
    CadrServiceFakeImpl service;

    @RequestMapping("/get/list")
    List<Cadr> getAll() throws IOException {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Cadr get(@PathVariable("id") String id) {
        return service.get(id);
    }

}
