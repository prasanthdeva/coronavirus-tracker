package com.prasanth.coranavirustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prasanth.coranavirustracker.model.Locationstats;
import com.prasanth.coranavirustracker.services.Coronavirusdata;

@Controller
public class Homecontroller {
	
	@Autowired
	Coronavirusdata coronavirusdata;
	
	@GetMapping("/")
	public String home(Model model)
	{
		List<Locationstats> allstats = coronavirusdata.getAllstats();
		int totalcases = allstats.stream().mapToInt(stat-> stat.getLatesttotalcases()).sum();
		model.addAttribute("locationstats", allstats);
		model.addAttribute("totalreportedcases",totalcases);
		
		return "home";
	}

}
