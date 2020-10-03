package com.ymdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ymdev.models.DefenseSession;
import com.ymdev.service.IDefenseSessionService;
import com.ymdev.service.ISectionService;


@Controller
@RequestMapping(value="/defense")
public class DefenseController {
	
	@Autowired
	private IDefenseSessionService dfservice;
	@Autowired
	private ISectionService scservice;
	
	@RequestMapping(value="/list")
	public String listOfDefenseSessions(Model model ) {
		model.addAttribute("defenses", dfservice.findAll());
		return "defense_list";
	}
	
	@RequestMapping("/new")
	public String addDefense(Model model) {
		model.addAttribute("defense", new DefenseSession());
		model.addAttribute("sections", scservice.findAll());
		return "defense_form";
	}
	
	@RequestMapping("/save")
	public String saveDefense(@ModelAttribute DefenseSession defense) {
		dfservice.saveOrUpdate(defense);
		return "redirect:/defense/list";
	}
	
	@RequestMapping("/delete/{defenseId}")
	public String deleteDefense(@PathVariable long defenseId) {
		dfservice.delete(defenseId);
		return "redirect:/defense/list";
	}
	
	@RequestMapping("/edit/{defenseId}")
	public ModelAndView editDefense(@PathVariable long defenseId) {
		ModelAndView mav = new ModelAndView("defense_edit");
		DefenseSession defense = dfservice.getById(defenseId);
		mav.addObject("defense",defense);
		mav.addObject("sections",scservice.findAll());
		return mav;
	}
	
	
	
	
}
