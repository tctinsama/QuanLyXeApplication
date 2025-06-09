package org.example.controller;

import org.example.model.Xe;
import org.example.service.Xe.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/xe")
public class XeController {

    @Autowired
    private XeService xeService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("xe", new Xe());
        return "Xe/xeCreate";
    }

    @PostMapping
    public String save(Xe xe, Model model) {
        try {
            xeService.save(xe);
            return "redirect:/xe/new";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "Xe/xeCreate";
        }
    }
}
