package com.telusko.jpadata.springdata.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.jpadata.springdata.dao.AlienRepo;
import com.telusko.jpadata.springdata.model.Alien;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	//to establish the connection of model and controler we need to import one more dependency "tomcat-jasper"
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/findAlien")
	public ModelAndView findAlien(@RequestParam int aid) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;
	}
	
	//creating our own search paramenter using Alien Repo A.K.A spring data
	@RequestMapping("/findByTech")
	public ModelAndView findByTech(@RequestParam String tech) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
//		List<Alien> myList=new ArrayList<Alien>();
//		myList=repo.findByTech(tech);
		System.out.println(repo.findByTech("tech"));
		//mv.addObject(myList);
		return mv;
	}
	
	@RequestMapping("/findByAidGreaterThan")
	public ModelAndView findByAidGreaterThan(@RequestParam int aid) {
		ModelAndView mv=new ModelAndView("showAlien.jsp");
//		List<Alien> myList=new ArrayList<Alien>();
//		myList=repo.findByAidGreaterThan(aid);
		System.out.println(repo.findByAidGreaterThan(aid));
//		mv.addObject(myList);
		return mv;
	}
	
	//my own query
	@RequestMapping("/findBySortedname")
	public ModelAndView findByTechSorted(@RequestParam String tech) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		System.out.println(repo.findByTechSorted(tech));
		return mv;
	}
	
	//now we will be creating a Rest Application
	@ResponseBody
	@RequestMapping(path="/aliens", produces= {"application/xml"})
	public String getAliens() {
		return repo.findAll().toString();
	}
	
	// REST APi for viewing all the data present in the database
	//here commneted parts are from CRUD Repository which we used in earlier process....now we are using JAPRepository for getting JSON output and additional benefit 
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	//public String getAlien(@PathVariable("aid") int aid) {
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		//return repo.findById(aid).toString();
		return repo.findById(aid);
	}
	
	//Rest API for inserting an element in the database
	@RequestMapping(path="/addNewRestAlien", consumes= {"application/Json"}, method=RequestMethod.POST)
	@ResponseBody
	public Alien addNewRestAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	//REST API for deleteing the data from the database
	@RequestMapping(path="/deleteRestAlien/{aid}", method=RequestMethod.DELETE )
	@ResponseBody
	public String deleteRestAlien(@PathVariable("aid") int aid) {
		//Alien alien=repo.findById(aid).orElse(new Alien());
		Alien alien = repo.getOne(aid);
		repo.delete(alien);
		return "deleted";
	}
	
	@RequestMapping(path="/Alien", consumes= {"application/Json"}, method=RequestMethod.PUT )
	@ResponseBody
	public Alien saveOrUpdate(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
}
