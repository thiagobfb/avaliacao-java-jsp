package com.thiagobfb.avaliacaojavajsp.controller;

import com.thiagobfb.avaliacaojavajsp.domain.Projeto;
import com.thiagobfb.avaliacaojavajsp.services.ProjetoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @GetMapping("/viewProjetos")
    public String viewBooks(Model model) {
        model.addAttribute("projetos", service.getProjetos());
        return "view-projetos";
    }

    @PostMapping("/addProjeto")
    public RedirectView addBook(@ModelAttribute("projeto") Projeto projeto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/projeto/addProjeto", true);
        Projeto savedProjeto = service.addProjeto(projeto);
        redirectAttributes.addFlashAttribute("savedProjeto", savedProjeto);
        redirectAttributes.addFlashAttribute("addProcessoSuccess", true);
        return redirectView;
    }

    @GetMapping(value = "/delete-projeto")
    public String deleteProjeto(@RequestParam long id) {
        service.deleteProjeto(id);
        return "redirect:/list-todos";
    }

    @GetMapping(value = "/update-projeto")
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Projeto projeto = service.getProjetoPorId(id);
        model.put("projeto", projeto);
        return "projeto";
    }

    @PostMapping(value = "/update-projeto")
    public String updateTodo(ModelMap model, Projeto projeto, BindingResult result) {

        if (result.hasErrors()) {
            return "projeto";
        }

        service.update(projeto);
        return "redirect:/view-projetos";
    }
}
