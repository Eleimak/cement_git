package tam.cement.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tam.cement.model.Generic;
import tam.cement.service.generic.impls.GenericServiceImpl;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/generic")
public class GenericControllerREST {

    @Autowired
    GenericServiceImpl service;

    @RequestMapping("/get/list")
    List<Generic> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Generic get(@PathVariable("id") String id) {
        return service.get(id);
    }

}
