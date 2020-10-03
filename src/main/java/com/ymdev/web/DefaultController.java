package com.ymdev.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ymdev.models.Meeting;
import com.ymdev.models.Professor;
import com.ymdev.models.Student;
import com.ymdev.service.IMeetingService;
import com.ymdev.service.IPfeService;
import com.ymdev.service.IStudentService;

@Controller
public class DefaultController {
	
	private static String UPLOADED_FOLDER = "C://work//";
	@Autowired
	private IMeetingService dfservice;
	
	@Autowired
	private IPfeService pservice;
	
	@Autowired
	private IStudentService stservice;

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}
	@RequestMapping(value = "/student_home/{idstudent}")
	public String Shome(Model model, @PathVariable long idstudent) {
		Student student = stservice.getById(idstudent);
		model.addAttribute("student",student);
		return "student_home";
	}
	@RequestMapping(value = "/pv_form")
	public String pvForm() {
		return "pv_form";
	}


	@RequestMapping(value = "/admin")
	public String admin(Model model) {
		return "admin";
	}

	@RequestMapping(value = "/login_student_form")
	public String loginStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student_login";
	}

	@RequestMapping(value = "/login_professor_form")
	public String loginProfessorForm(Model model) {
		model.addAttribute("professor", new Professor());
		return "professor_login";
	}
	
	@PostMapping("/upload/{userId}") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model, @PathVariable long userId) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Meeting> meetings = dfservice.findByPfe(pservice.getByStudent(stservice.getById(userId)));
		model.addAttribute("meetings",meetings);
		model.addAttribute("pfe",pservice.getByStudent(stservice.getById(userId)));
		return "student_meeting";
	}

}