package org.example.controller;

import org.example.dto.resp.XeLichTrinhInfoResp;
import org.example.service.Xe.XeService;
import org.example.service.LoaiXe.LoaiXeService;
import org.example.service.NhaXe.NhaXeService;

import org.example.model.Xe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/xe")
public class XeController {
    @Autowired
    private XeService xeService;

    @Autowired
    private  LoaiXeService loaiXeService;

    @Autowired
    private NhaXeService nhaXeService;

    // Show form create
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("xe", new Xe());
        model.addAttribute("loaixes", loaiXeService.findAll());
        model.addAttribute("nhaxes", nhaXeService.findAll());
        return "Xe/xeCreate";
    }

    // Handle create
    // Xử lý lưu xe mới
    @PostMapping("/save")
    public String save(@ModelAttribute("xe") Xe xe, Model model) {
        try {
            xeService.save(xe);
            return "redirect:/xe/create?success"; // redirect có thể kèm param báo thành công
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("loaixes", loaiXeService.findAll());
            model.addAttribute("nhaxes", nhaXeService.findAll());
            return "Xe/xeCreate"; // Trả lại form với thông báo lỗi
        }
    }

    @GetMapping("/lichtrinh")
    public String danhSachXeLichTrinh(
            @RequestParam(value = "tenNhaXe", required = false) String tenNhaXe,
            Model model) {

        // Nếu ko có tên nhà xe thì truyền rỗng để lấy tất cả
        if (tenNhaXe == null) {
            tenNhaXe = "";
        }

        List<XeLichTrinhInfoResp> dsXe = xeService.getXeLichTrinh(tenNhaXe);
        model.addAttribute("dsXe", dsXe);
        model.addAttribute("tenNhaXe", tenNhaXe);
        return "Xe/lichtrinh";
    }

//    // Show form edit
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable("id") String id, Model model) {
//        Optional<May> may = mayService.findById(id);
//        if (may.isPresent()) {
//            model.addAttribute("may", may.get());
//            return "may/MayEdit";
//        } else {
//            return "redirect:/may";
//        }
//    }
//
//    // Handle update
//    @PostMapping("/update/{id}")
//    public String update(@PathVariable("id") String id, @ModelAttribute("may") May may) {
//        mayService.update(id, may);
//        return "redirect:/may";
//    }
//
//    // Delete
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") String id) {
//        mayService.deleteById(id);
//        return "redirect:/may";
//    }
//
//    //page
//    @GetMapping
//    public String listMay(
//            @RequestParam(defaultValue = "1") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(name = "keyword", required = false) String keyword,
//            Model model) {
//
//        Page<May> mayPage;
//        if (keyword != null && !keyword.isEmpty()) {
//            mayPage = mayService.searchByMaMay(keyword, PageRequest.of(page - 1, size));
//            model.addAttribute("keyword", keyword);
//        } else {
//            mayPage = mayService.findAll(PageRequest.of(page - 1, size));
//        }
//        model.addAttribute("khachhangPage", mayPage);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", mayPage.getTotalPages());
//        model.addAttribute("pageSize", size);
//        return "may/MayList";
//    }
}
