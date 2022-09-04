package com.sistema.refa.almacen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlmacenController {
	
	@Autowired
	private AlmacenRepository almacenRepository;
	
	@GetMapping("/almacenes")
	public String listarAlmacenes(Model modelo) {
		List<Almacen> listaAlmacenes=almacenRepository.findAll();
		modelo.addAttribute("listaAlmacenes", listaAlmacenes);
		return "almacenes";
	}
	
	@GetMapping("/almacenes/nuevo")
	public String mostrarFormularioDeNuevoAlmacen(Model modelo) {
		modelo.addAttribute("almacen", new Almacen());
		return "almacen_formulario";
	}
	
	@PostMapping("/almacenes/guardar")
		public String guardarAlmacen(Almacen almacen) {
		almacenRepository.save(almacen);
		return "redirect:/almacenes";			
	}
	
	@GetMapping("/almacenes/editar/{id}")
	public String mostrarFormularioDeModificarAlmacen(@PathVariable("id") Integer id,Model modelo) {
		Almacen almacen=almacenRepository.findById(id).get();
		modelo.addAttribute("almacen",almacen);
		
		return "almacen_formulario";
	}
	
	@GetMapping("/almacenes/eliminar/{id}")
	public String eliminarAlmacen(@PathVariable("id") Integer id, Model modelo) {
		almacenRepository.deleteById(id);
		return "redirect:/almacenes";
	}

}
