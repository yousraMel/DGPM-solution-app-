package com.ymdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ymdev.models.Student;
import com.ymdev.service.ISectionService;
import com.ymdev.service.IStudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private IStudentService stservice;
	
	@Autowired
	private ISectionService scservice;
	
	@RequestMapping(value="/list")
	public String listOfStudents(Model model ) {
		model.addAttribute("students", stservice.findAll());
		return "student_list";
	}
	
	@RequestMapping("/new")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("sections", scservice.findAll());
		return "student_form";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		stservice.saveOrUpdate(student);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete/{userId}")
	public String deleteStudent(@PathVariable long userId) {
		stservice.delete(userId);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/edit/{userId}")
	public ModelAndView editStudent(@PathVariable long userId) {
		ModelAndView mav = new ModelAndView("student_edit");
		Student student = stservice.getById(userId);
		mav.addObject("student",student);
		mav.addObject("sections", scservice.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/login_student")
	public String loginStudent(@ModelAttribute Student student, Model model) {
		model.addAttribute("student",
				stservice.getByCardIdAndPassword(student.getStudentIDCard(), student.getPassword()));
		System.out.println("Here: "+ stservice.getByCardIdAndPassword(student.getStudentIDCard(), student.getPassword()));
		return "student_home";
	}

}
