package com.pactice.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NinjaGoldController {

	@RequestMapping("/")
	public String start() {
		return "start.jsp";
	}
	
	@RequestMapping("/gold")
	public String game(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("activity") == null) {
			session.setAttribute("activity", "There is No Recent Activity!");
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("activity", session.getAttribute("activity"));
		return "main.jsp";
	}
	
//	FARM ROUTE
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		LocalDateTime dateL = LocalDateTime.now();
		DateTimeFormatter dateF = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a");
		String date = dateL.format(dateF);
		int found = (int) ((Math.random() * (20 - 10)) + 10);
		int total = (int) session.getAttribute("gold");
		total += found;
		session.setAttribute("gold", total);
		String acts = (String) session.getAttribute("activity");
		acts =  "You've entered a farm and earned " + found + " gold. (" + date + ")" + "\n" + acts;
		session.setAttribute("activity", acts);
		return "redirect:/gold";
	}
	
//	CAVE ROUTE
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		LocalDateTime dateL = LocalDateTime.now();
		DateTimeFormatter dateF = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a");
		String date = dateL.format(dateF);
		int found = (int) ((Math.random() * (10 - 5)) + 5);
		int total = (int) session.getAttribute("gold");
		total += found;
		session.setAttribute("gold", total);
		String acts = (String) session.getAttribute("activity");
		acts = "You've entered a cave and earned " + found + " gold. (" + date + ")" + "\n" + acts;
		session.setAttribute("activity", acts);
		return "redirect:/gold";
	}
	
//	HOUSE ROUTE
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		LocalDateTime dateL = LocalDateTime.now();
		DateTimeFormatter dateF = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a");
		String date = dateL.format(dateF);
		int found = (int) ((Math.random() * (10 - 5)) + 5);
		int total = (int) session.getAttribute("gold");
		total += found;
		session.setAttribute("gold", total);
		String acts = (String) session.getAttribute("activity");
		acts = "You've entered a house and earned " + found + " gold. (" + date + ")" + "\n" + acts;
		session.setAttribute("activity", acts);
		return "redirect:/gold";
	}
	
//	CASINO ROUTE
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		LocalDateTime dateL = LocalDateTime.now();
		DateTimeFormatter dateF = DateTimeFormatter.ofPattern("MMMM dd yyyy HH:mm a");
		String date = dateL.format(dateF);
		int found;
		int chance = (int) ((Math.random() * (10 - 1)) + 1);
		if (chance % 3 == 0) {
			found = (int) ((Math.random() * (50 - 0)) + 0);
		}
		else {
			found = (int) ((Math.random() * (50 - 0)) + 0) * -1;
		}
		int total = (int) session.getAttribute("gold");
		total += found;
		session.setAttribute("gold", total);
		String acts = (String) session.getAttribute("activity");
		acts = "You've entered a casino and earned " + found + " gold. (" + date + ")" + "\n" + acts;
		session.setAttribute("activity", acts);
		return "redirect:/gold";
	}
	
}
