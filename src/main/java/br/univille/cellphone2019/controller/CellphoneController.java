package br.univille.cellphone2019.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.cellphone2019.model.Cellphone;
import br.univille.cellphone2019.service.CellphoneService;

@Controller
@RequestMapping("/cellphone")
public class CellphoneController {
	
	@Autowired
	private CellphoneService service;
	
	@GetMapping()
	public ModelAndView index() {
		
		return new ModelAndView("cellphone/index","cellphone",service.getAll());
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Cellphone cellphone) {
		return new ModelAndView("cellphone/form");
	}
	

	@PostMapping(params="form")
	public ModelAndView save(@Valid Cellphone cellphone ) {
		service.save(cellphone);
		return new ModelAndView("redirect:/cellphone");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Cellphone cellphone) {

		return new ModelAndView("cellphone/form","cellphone",cellphone);
	}
	
	@GetMapping(value="/excluir/{id}")
	public ModelAndView remove(@PathVariable ("id") Cellphone cellphone) {
		service.remove(cellphone);
		return new ModelAndView ("redirect:/cellphone");
	}
	
	

}
