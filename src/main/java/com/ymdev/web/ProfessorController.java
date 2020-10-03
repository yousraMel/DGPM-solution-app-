package com.ymdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ymdev.models.Professor;
import com.ymdev.models.Student;
import com.ymdev.service.IFileService;
import com.ymdev.service.IFileStorageService;
import com.ymdev.service.IPfeService;
import com.ymdev.service.IProfessorService;

@Controller
@RequestMapping(value="/professor")
public class ProfessorController {
	
	@Autowired
	private IProfessorService prservice;
	

	@Autowired
	private IFileService service;
	
	@Autowired
	private IPfeService pfservice;
	
	@Autowired
	 private IFileStorageService storageService;
	
	@RequestMapping(value="/list")
	public String listOfProfessors(Model model ) {
		model.addAttribute("professors", prservice.findAll());
		return "professor_list";
	}
	
	@RequestMapping("/new")
	public String addProfessor(Model model) {
		model.addAttribute("professor", new Professor());
		return "professor_form";
	}
	
	@RequestMapping("/save")
	public String saveProfessor(@ModelAttribute Professor professor) {
		prservice.saveOrUpdate(professor);
		return "redirect:/professor/list";
	}
	
	@RequestMapping("/delete/{userId}")
	public String deleteProfessor(@PathVariable long userId) {
		prservice.delete(userId);
		return "redirect:/professor/list";
	}
	
	@RequestMapping("/edit/{userId}")
	public ModelAndView editProfessor(@PathVariable long userId) {
		ModelAndView mav = new ModelAndView("professor_edit");
		Professor professor = prservice.getById(userId);
		mav.addObject("professor",professor);
		return mav;
	}
	
	@RequestMapping(value = "/login_professor")
	public String loginProfessor(@ModelAttribute Professor professor, Model model) {
		model.addAttribute("professor",
				prservice.getByMatricul(professor.getMatricul()));
		System.out.println("Here: "+ prservice.getByMatricul(professor.getMatricul()));
		return "professor_home";
	}
	
	@RequestMapping(value = "/home/{userId}")
	public String loginProfessor( Model model, @PathVariable long userId) {
		model.addAttribute("professor", prservice.getById(userId));
		return "professor_home";
	}

	
	@RequestMapping(value = "/pfe_tosupervise/{userId}")
	public String PfeToSuperviseList( Model model,@PathVariable long userId) {
		model.addAttribute("pfesToSupervise", prservice.getById(userId).getPfesToSuperivise());
		model.addAttribute("supervisor", prservice.getById(userId));
		return "professor_listpfetosupervise";
	}

	@RequestMapping(value = "/pfe_toreport/{userId}")
	public String PfeToReportList( Model model,@PathVariable long userId) {
		model.addAttribute("pfesToReport", prservice.getById(userId).getPfesToReport());
		model.addAttribute("reporter", prservice.getById(userId));
		return "professor_listpfetoreport";
	}
	
	@RequestMapping(value = "/pfe_tovalidate/{userId}")
	public String PfeToValidateList( Model model,@PathVariable long userId) {
		model.addAttribute("pfesToValidate", prservice.getById(userId).getPfesToValidate());
		model.addAttribute("validator", prservice.getById(userId));
		return "professor_listpfetovalidate";
	}
	
	
	
	
}
