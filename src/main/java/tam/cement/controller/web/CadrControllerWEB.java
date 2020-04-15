package tam.cement.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tam.cement.model.Cadr;
import tam.cement.service.cadr.impls.CadrServiceFakeImpl;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/web/cadr")
public class CadrControllerWEB {

    private final CadrServiceFakeImpl cadrServiceFake;

    public CadrControllerWEB(CadrServiceFakeImpl cadrServiceFake) {
        this.cadrServiceFake = cadrServiceFake;
    }

    @RequestMapping("/get/list")
    String showAll(Model model) throws IOException {
        List<Cadr> list = cadrServiceFake.getAll();
        model.addAttribute("list", list);
        return "cadrList";

    }

    @RequestMapping("/get/{id}")
    String show(@PathVariable("id") String id) {
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String createGet(Model model) {

        return "/cadrAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("Cadr") Cadr cadr){

        return "redirect:/web/cadr/get/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")String id){
        cadrServiceFake.delete(id);
        return "redirect:/web/cadr/get/list";
    }

}
