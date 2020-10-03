package com.ymdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ymdev.models.Section;
import com.ymdev.service.ISectionService;


@Controller
@RequestMapping(value="/section")
public class SectionController {
	
	@Autowired
	private ISectionService scservice;
	
	@RequestMapping(value="/list")
	public String listOfSections(Model model ) {
		model.addAttribute("sections", scservice.findAll());
		return "section_list";
	}
	
	@RequestMapping("/new")
	public String addSection(Model model) {
		model.addAttribute("section", new Section());
		return "section_form";
	}
	
	@RequestMapping("/save")
	public String saveSection(@ModelAttribute Section section) {
		scservice.saveOrUpdate(section);
		return "redirect:/section/list";
	}
	
	@RequestMapping("/delete/{sectionId}")
	public String deleteSection(@PathVariable long sectionId) {
		scservice.delete(sectionId);
		return "redirect:/section/list";
	}
	
	@RequestMapping("/edit/{sectionId}")
	public ModelAndView editSection(@PathVariable long sectionId) {
		ModelAndView mav = new ModelAndView("section_edit");
		Section section = scservice.getById(sectionId);
		mav.addObject("section",section);
		return mav;
	}
	
	
	
	
}
