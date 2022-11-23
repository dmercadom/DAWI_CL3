package com.CL3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.CL3.model.Reservas;
import com.CL3.repository.ICarrerasRepository;
import com.CL3.repository.IReservasRepository;

@Controller
public class ReservasController {
	
	@Autowired
	private ICarrerasRepository repocar;
	@Autowired
	private IReservasRepository repores;
		
	@GetMapping("/listado")
	public String listadoDeReservas(Model model ) {
		model.addAttribute("lstReservas", repores.findAll());
		return "reservaMercado";
	}
	
	@PostMapping("/editar")
	public String buscarReservas(@ModelAttribute Reservas r, Model model) {
		System.out.println(r);  
		model.addAttribute("reservas", repores.findById(r.getCodigo()) );
		model.addAttribute("txtbtn","Actualizar");
		model.addAttribute("lstCarreras", repocar.findAll());
		model.addAttribute("txtbtn","Actualizar");
		return "reservaMercado";
	}
	
	@PostMapping("/grabar")
	public String grabarReservas(@ModelAttribute Reservas reservas, Model model) {
		System.out.println(reservas);  	
		// grabar en la tabla
		try {
			repores.save(reservas);
			// muestra mensaje de éxito
			model.addAttribute("mensaje","Matricula registrado");
			model.addAttribute("clase","alert alert-success");
		} catch (Exception e) {
			// muestra mensaje de error
			model.addAttribute("mensaje","Error al registrar Matricula");
			model.addAttribute("clase","alert alert-danger");
		}
		// vuelve a listar los combos
		model.addAttribute("lstCarreras", repocar.findAll());
		model.addAttribute("txtbtn","Actualizar");
		return "reservaMercado";
	}
	@GetMapping("/cargar")
	public String abrirPagReservas(Model model ) {
		model.addAttribute("reservas", new Reservas());
		model.addAttribute("lstCarreras", repocar.findAll());
		model.addAttribute("txtbtn","Registrar");
		return "reservaMercado";
	}
	
	
	
}
