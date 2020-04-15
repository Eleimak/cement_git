package tam.cement.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tam.cement.model.Generic;
import tam.cement.service.generic.impls.GenericServiceImpl;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/web/generic")
public class GenericControllerWEB {

    @Autowired
    GenericServiceImpl service;

    @RequestMapping("/get/list")
    String showAll(Model model) {

        List<Generic> list = service.getAll();
        model.addAttribute("list", list);
        return "genericList";

    }

    @RequestMapping("/get/{id}")
    String show(@PathVariable("id") String id) {
        return null;
    }

}
