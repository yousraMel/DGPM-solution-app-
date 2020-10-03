package com.ymdev.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.ymdev.models.File;
import com.ymdev.models.Pfe;
import com.ymdev.service.IPfeService;
import com.ymdev.service.IProfessorService;
import com.ymdev.service.IStudentService;

@Controller
@RequestMapping(value="/pfe")
public class PfeController {
	
	@Autowired
	private IPfeService pfservice;
	@Autowired
	private IProfessorService prservice;
	@Autowired
	private IStudentService stservice;
	
	@RequestMapping(value="/list")
	public String listOfPfes(Model model ) {
		model.addAttribute("pfes", pfservice.findAll());
		return "pfe_list";
	}
	
	@RequestMapping("/new")
	public String addPfe(Model model) {
		model.addAttribute("pfe", new Pfe());
		model.addAttribute("profs", prservice.findAll());
		model.addAttribute("students", stservice.findAll());
		
		return "pfe_form";
	}
	
	@RequestMapping("/save")
	public String savePfe(@ModelAttribute Pfe pfe) {
		System.out.println(pfe.getSupervisor().getUserId());
		System.out.println(pfe.getSupervisor());
		pfservice.saveOrUpdate(pfe);
		return "redirect:/pfe/list";
	}
	
	@RequestMapping("/delete/{pfeId}")
	public String deletePfe(@PathVariable long pfeId) {
		pfservice.delete(pfeId);
		return "redirect:/pfe/list";
	}
	
	@RequestMapping("/edit/{pfeId}")
	public ModelAndView editPfe(@PathVariable long pfeId) {
		ModelAndView mav = new ModelAndView("pfe_edit");
		Pfe pfe = pfservice.getById(pfeId);
		mav.addObject("pfe",pfe);
		mav.addObject("profs", prservice.findAll());
		mav.addObject("students", stservice.findAll());
		return mav;
	}
	
	@RequestMapping("/show/{pfeId}")
	public ModelAndView detailsPfe(@PathVariable long pfeId) {
		ModelAndView mav = new ModelAndView("pfe_details");
		Pfe pfe = pfservice.getById(pfeId);
		System.out.println(pfe);
		mav.addObject("pfe",pfe);
		return mav;
	}
	
	@RequestMapping("/details/{pfeId}")
	public ModelAndView detailsPfeforProf(@PathVariable long pfeId) {
		ModelAndView mav = new ModelAndView("pfe_details");
		Pfe pfe = pfservice.getById(pfeId);
		System.out.println(pfe);
		mav.addObject("pfe",pfe);
		return mav;
	}
	
	@RequestMapping("/pfe_student/{userId}")
	public ModelAndView PfeByStudent(@PathVariable long userId) {
		System.out.println(userId);
		ModelAndView mav = new ModelAndView("student_pfe");
		Pfe pfe = stservice.getById(userId).getPfe();
		mav.addObject("pfe",pfe);
		return mav;
	}
	
	
}
