package testApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import testApp.service.StatisticService;

@Controller
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/")
    public String showFiles(Model model){

        model.addAttribute("files", statisticService.getFilesList());
        return "files";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable("id")Long id, Model model){

        model.addAttribute("details", statisticService.getFileDetails(id));
        return "details";
    }

}
