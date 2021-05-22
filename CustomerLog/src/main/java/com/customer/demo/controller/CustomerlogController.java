package com.customer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.model.CustomerlogModel;
import com.customer.demo.service.CustomerlogService;


@RestController
public class CustomerlogController {
	@Autowired
	CustomerlogService logservice;

	@GetMapping("/checkIn")
	public String addCheckin(@RequestParam("name") String name) {
		logservice.addCheckin(name);
		return "";
	}
	@GetMapping("/checkOut")
	public String addCheckout(@RequestParam("name") String name) {
		logservice.addCheckout(name);
		return "";
	}
	@GetMapping(value="/getAllLog")
    
	public List<CustomerlogModel> getAllLog()
	{
	 return logservice.getAllLog();
	}
    @GetMapping(value="/getLog")
    
	public List<CustomerlogModel> getLog(@RequestParam("date") String date)
	{
	 return logservice.getLog(date);
	}

}