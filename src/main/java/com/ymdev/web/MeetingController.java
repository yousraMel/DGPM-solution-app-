package com.ymdev.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ymdev.models.Meeting;
import com.ymdev.service.IMeetingService;
import com.ymdev.service.IPfeService;
import com.ymdev.service.IStudentService;

@Controller
@RequestMapping(value="/meeting")
public class MeetingController {
	
	@Autowired
	private IMeetingService dfservice;
	
	@Autowired
	private IPfeService pservice;
	
	@Autowired
	private IStudentService stservice;
	
	@RequestMapping(value="/list")
	public String listOfMeetings(Model model ) {
		model.addAttribute("meetings", dfservice.findAll());
		return "meeting_list";
	}
	
	@RequestMapping("/new")
	public String addDefense(Model model) {
		model.addAttribute("meeting", new Meeting());
		return "meeting_form";
	}
	
	@RequestMapping("/meeting_form/{pfeId}")
	public String addMeeting(@PathVariable long pfeId, Model model) {
		model.addAttribute("meeting", new Meeting());
		model.addAttribute("pfeselected", pservice.getById(pfeId));
		System.out.println(pservice.getById(pfeId));
		return "meeting_form";
	}
	
	@RequestMapping("/save")
	public String saveDefense(@ModelAttribute Meeting meeting, Model model) {
		dfservice.saveOrUpdate(meeting);
		model.addAttribute("student", meeting.getPfe().getStudent());
		return "student_home";
	}
	
	@RequestMapping("/save/{pfeId}")
	public String saveMeetingByPfe(@PathVariable long pfeId, @ModelAttribute Meeting meeting, Model model) {
		meeting.setPfe(pservice.getById(pfeId));
		dfservice.saveOrUpdate(meeting);
		List<Meeting> meetings = pservice.getById(pfeId).getMeetings();
		model.addAttribute("meetings",meetings);
		model.addAttribute("pfe", pservice.getById(pfeId));
		model.addAttribute("student",meeting.getPfe().getStudent());
		return "student_home";
	}
	
	@RequestMapping("/delete/{meetingId}")
	public String deleteDefense(@PathVariable long meetingId) {
		dfservice.delete(meetingId);
		return "redirect:/meeting/list";
	}
	
	@RequestMapping("/edit/{meetingId}")
	public ModelAndView editDefense(@PathVariable long meetingId) {
		ModelAndView mav = new ModelAndView("meeting_edit");
		Meeting meeting = dfservice.getById(meetingId);
		mav.addObject("meeting",meeting);
		return mav;
	}
	
	@RequestMapping("/meeting_student/{userId}")
	public String meetingByStudent(@PathVariable long userId, Model model) {
		List<Meeting> meetings   = new ArrayList<Meeting>();
		String message = "";
		 try {
			meetings = stservice.getById(userId).getPfe().getMeetings();
		} catch (Exception e) {
			message="You have save no meeting yet. Please enter some to mark your hardworking !";
			e.getStackTrace();
		}
		model.addAttribute("meetings",meetings);
		model.addAttribute("message",message);
		model.addAttribute("pfe",stservice.getById(userId).getPfe());
		return "student_meeting";
	}
	
	
}
